package account.services.transactions;

import account.domain.Account;
import account.domain.TransactionEvent;
import account.domain.TransactionStatus;
import account.repository.AccountRepository;
import account.sm.TransactionStateChangeInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionManagerImpl implements TransactionManager {


    public static final String TRANSACTION_ID_HEADER = "TRANSACTION_ID_HEADER";

    private final StateMachineFactory<TransactionStatus, TransactionEvent> stateMachineFactory;
    private final AccountRepository repository;
    private final TransactionStateChangeInterceptor interceptor;

    @Transactional
    @Override
    public Account generateNewAccount(Account account) {

        account.setId(null);
        account.setStatus(TransactionStatus.NEW);

        Account savedAccount = repository.save(account);
        sendTransactionEvent(savedAccount, TransactionEvent.VALIDATE_NEW_ACCOUNT);

        return savedAccount;
    }

    private void sendTransactionEvent(Account account, TransactionEvent event){
        StateMachine<TransactionStatus, TransactionEvent> sm = build(account);

        Message msg = MessageBuilder.withPayload(event)
                        .setHeader(TRANSACTION_ID_HEADER, account.getId().toString())
                        .build();

        sm.sendEvent(msg);
    }

    private StateMachine<TransactionStatus, TransactionEvent> build(Account account){

        StateMachine<TransactionStatus, TransactionEvent> sm = stateMachineFactory.getStateMachine(account.getId());

        sm.stop();

        sm.getStateMachineAccessor()
                .doWithAllRegions(sma -> {
                    sma.addStateMachineInterceptor(interceptor);
                    sma.resetStateMachine(new DefaultStateMachineContext<>(account.getStatus(), null, null, null));
                });

        sm.start();

        return sm;
    }
}

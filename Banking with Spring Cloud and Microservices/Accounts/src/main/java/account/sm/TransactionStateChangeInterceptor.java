package account.sm;

import account.domain.Account;
import account.domain.TransactionEvent;
import account.domain.TransactionStatus;
import account.repository.AccountRepository;
import account.services.transactions.TransactionManagerImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Component
@Slf4j
public class TransactionStateChangeInterceptor extends StateMachineInterceptorAdapter<TransactionStatus, TransactionEvent> {

    private final AccountRepository repository;

    @Override
    public void preStateChange(State<TransactionStatus, TransactionEvent> state, Message<TransactionEvent> message, Transition<TransactionStatus, TransactionEvent> transition, StateMachine<TransactionStatus, TransactionEvent> stateMachine) {
        Optional.ofNullable(message)
                .flatMap(msg -> Optional.ofNullable((String) msg.getHeaders().getOrDefault(TransactionManagerImpl.TRANSACTION_ID_HEADER, " ")))
                .ifPresent(orderId -> {
                    log.debug("Saving state for order id: " + orderId + " Status: " + state.getId());

                    Account account = repository.getOne(UUID.fromString(orderId));
                    account.setStatus(state.getId());
                    repository.saveAndFlush(account);
                });
    }
}

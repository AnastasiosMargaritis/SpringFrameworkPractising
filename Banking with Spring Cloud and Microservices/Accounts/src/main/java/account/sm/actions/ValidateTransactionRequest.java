package account.sm.actions;

import account.config.JmsConfig;
import account.domain.Account;
import account.domain.TransactionEvent;
import account.domain.TransactionStatus;
import account.repository.AccountRepository;
import account.services.transactions.TransactionManagerImpl;
import account.web.model.events.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateTransactionRequest implements Action<TransactionStatus, TransactionEvent> {


    private final AccountRepository repository;
    private final JmsTemplate jmsTemplate;

    @Override
    public void execute(StateContext<TransactionStatus, TransactionEvent> stateContext) {

        String accountId = (String) stateContext.getMessage().getHeaders().get(TransactionManagerImpl.TRANSACTION_ID_HEADER);

        Account account = repository.findById(UUID.fromString(accountId)).get();

        jmsTemplate.convertAndSend(JmsConfig.NEW_ACCOUNT_EVENT, TransactionRequest.builder()
                    .dto(account));

        log.debug("Sent Validation request to queue for order id " + accountId);
    }
}

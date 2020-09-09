package account.sm;

import account.domain.TransactionEvent;
import account.domain.TransactionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
@RequiredArgsConstructor
public class TransactionStateMachineConfig extends StateMachineConfigurerAdapter<TransactionStatus, TransactionEvent> {

    private final Action<TransactionStatus, TransactionEvent> validateTransactionRequest;

    @Override
    public void configure(StateMachineStateConfigurer<TransactionStatus, TransactionEvent> states) throws Exception {
        states.withStates()
                .initial(TransactionStatus.NEW)
                .initial(TransactionStatus.DELETE)
                .initial(TransactionStatus.WITHDRAW)
                .initial(TransactionStatus.UPDATE)
                .initial(TransactionStatus.DEPOSIT)
                .states(EnumSet.allOf(TransactionStatus.class))
                .end(TransactionStatus.DECLINED)
                .end(TransactionStatus.FINISHED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<TransactionStatus, TransactionEvent> transitions) throws Exception {
        transitions.withExternal()
                //
                .source(TransactionStatus.NEW)
                .target(TransactionStatus.VALIDATION_PENDING)
                .event(TransactionEvent.VALIDATE_NEW_ACCOUNT)
                .action(validateTransactionRequest)
                .and()
                //
                .withExternal()
                .source(TransactionStatus.NEW)
                .target(TransactionStatus.FINISHED)
                .event(TransactionEvent.VALIDATION_PASSED)
                .and()
                //
                .withExternal()
                .source(TransactionStatus.NEW)
                .target(TransactionStatus.DECLINED)
                .event(TransactionEvent.VALIDATION_FAILED);
    }
}

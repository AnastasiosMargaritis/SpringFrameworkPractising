package transactions.sm;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import transactions.domain.TransactionEvent;
import transactions.domain.TransactionStatus;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class TransactionStateMachineConfig extends StateMachineConfigurerAdapter<TransactionStatus, TransactionEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<TransactionStatus, TransactionEvent> states) throws Exception {
        states.withStates()
                .initial(TransactionStatus.NEW)
                .initial(TransactionStatus.DELETE)
                .initial(TransactionStatus.WITHDRAW)
                .initial(TransactionStatus.UPDATE)
                .initial(TransactionStatus.DEPOSIT)
                .states(EnumSet.allOf(TransactionStatus.class))
                .end(TransactionStatus.FINISHED);
    }
}

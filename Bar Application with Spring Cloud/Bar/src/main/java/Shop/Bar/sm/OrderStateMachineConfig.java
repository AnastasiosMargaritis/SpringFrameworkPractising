package Shop.Bar.sm;

import Shop.Bar.domain.sm.OrderEvents;
import Shop.Bar.domain.sm.OrderStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderEvents>{


    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderEvents> states) throws Exception {
        states.withStates()
                .initial(OrderStatus.NEW)
                .states(EnumSet.allOf(OrderStatus.class))
                .end(OrderStatus.PICKED_UP)
                .end(OrderStatus.DELIVERED)
                .end(OrderStatus.DELIVERY_EXCEPTION)
                .end(OrderStatus.VALIDATION_EXCEPTION)
                .end(OrderStatus.ALLOCATION_EXCEPTION);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderEvents> transitions) throws Exception {
        transitions.withExternal()
                .source(OrderStatus.NEW)
                .target(OrderStatus.VALIDATION_PENDING)
                .event(OrderEvents.VALIDATE_ORDER)
                //
        .and().withExternal()
                .source(OrderStatus.VALIDATION_PENDING)
                .target(OrderStatus.VALIDATED)
                .event(OrderEvents.VALIDATION_PASSED)
                //
        .and().withExternal()
                .source(OrderStatus.VALIDATION_PENDING)
                .target(OrderStatus.CANCELLED)
                .event(OrderEvents.CANCEL_ORDER)
                //
        .and().withExternal()
                .source(OrderStatus.VALIDATION_PENDING)
                .target(OrderStatus.VALIDATION_EXCEPTION)
                .event(OrderEvents.VALIDATION_FAILED)
                //
        .and().withExternal()
                .source(OrderStatus.VALIDATED)
                .target(OrderStatus.ALLOCATION_PENDING)
                .event(OrderEvents.ALLOCATE_ORDER)
                //
                .and().withExternal()
                .source(OrderStatus.VALIDATED).target(OrderStatus.CANCELLED)
                .event(OrderEvents.CANCEL_ORDER)
                .and().withExternal()
                .source(OrderStatus.ALLOCATION_PENDING).target(OrderStatus.ALLOCATED)
                .event(OrderEvents.ALLOCATION_SUCCESS)
                .and().withExternal()
                .source(OrderStatus.ALLOCATION_PENDING).target(OrderStatus.ALLOCATION_EXCEPTION)
                .event(OrderEvents.ALLOCATION_FAILED)
                .and().withExternal()
                .source(OrderStatus.ALLOCATION_PENDING).target(OrderStatus.CANCELLED)
                .event(OrderEvents.CANCEL_ORDER)
                .and().withExternal()
                .source(OrderStatus.ALLOCATION_PENDING).target(OrderStatus.PENDING_INVENTORY)
                .event(OrderEvents.ALLOCATION_NO_INVENTORY)
                .and().withExternal()
                .source(OrderStatus.ALLOCATED).target(OrderStatus.PICKED_UP)
                .event(OrderEvents.ORDER_PICKED_UP)
                .and().withExternal()
                .source(OrderStatus.ALLOCATED).target(OrderStatus.CANCELLED)
                .event(OrderEvents.CANCEL_ORDER);
    }
}

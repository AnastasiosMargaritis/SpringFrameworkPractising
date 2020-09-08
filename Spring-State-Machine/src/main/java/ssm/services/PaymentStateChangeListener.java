package ssm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;
import ssm.domain.Payment;
import ssm.domain.PaymentEvent;
import ssm.domain.PaymentState;
import ssm.repository.PaymentRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentStateChangeListener extends StateMachineInterceptorAdapter<PaymentState, PaymentEvent> {

    private final PaymentRepository repository;

    @Override
    public void preStateChange(State<PaymentState, PaymentEvent> state, Message<PaymentEvent> message,
                               Transition<PaymentState, PaymentEvent> transition,
                               StateMachine<PaymentState, PaymentEvent> stateMachine) {

        Optional.ofNullable(message).ifPresent(msg -> {
            Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault(PaymentServiceImpl.PAYMENT_ID_HEADER, -1L)))
                        .ifPresent(paymentId -> {
                            Payment payment = repository.getOne(paymentId);
                            payment.setState(state.getId());
                            repository.save(payment);
                        });
        });
    }
}

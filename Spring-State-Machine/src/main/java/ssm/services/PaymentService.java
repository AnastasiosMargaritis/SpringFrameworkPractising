package ssm.services;

import org.springframework.statemachine.StateMachine;
import ssm.domain.Payment;
import ssm.domain.PaymentEvent;
import ssm.domain.PaymentState;

public interface PaymentService {


    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);

}

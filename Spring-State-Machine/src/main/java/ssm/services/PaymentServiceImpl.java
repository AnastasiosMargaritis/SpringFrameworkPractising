package ssm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import ssm.domain.Payment;
import ssm.domain.PaymentEvent;
import ssm.domain.PaymentState;
import ssm.repository.PaymentRepository;
import org.springframework.messaging.Message;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final StateMachineFactory<PaymentState, PaymentEvent> state;
    private final PaymentStateChangeListener listener;

    public static final String PAYMENT_ID_HEADER = "payment_id";

    @Override
    public Payment newPayment(Payment payment) {
        payment.setState(PaymentState.NEW);
        return paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId) {

        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);

        sendEvent(paymentId, sm, PaymentEvent.PRE_AUTHORIZE);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId) {
        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);

        sendEvent(paymentId, sm, PaymentEvent.AUTHORIZE);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId) {
        StateMachine<PaymentState, PaymentEvent> sm = build(paymentId);

        sendEvent(paymentId, sm, PaymentEvent.AUTH_DECLINED);

        return sm;
    }

    private void sendEvent(Long paymentId, StateMachine<PaymentState, PaymentEvent> sm, PaymentEvent event){

        Message msm = (Message) MessageBuilder.withPayload(event)
                        .setHeader(PAYMENT_ID_HEADER, paymentId)
                        .build();

        sm.sendEvent(msm);
    }

    private StateMachine<PaymentState, PaymentEvent> build(Long paymentId){
        Payment payment = paymentRepository.getOne(paymentId);

        StateMachine<PaymentState, PaymentEvent> sm = state.getStateMachine(Long.toString(payment.getId()));

        sm.stop();

        sm.getStateMachineAccessor()
                .doWithAllRegions(sma -> {
                    sma.addStateMachineInterceptor(listener);
                    sma.resetStateMachine(new DefaultStateMachineContext<>(payment.getState(), null, null, null));
                });

        sm.start();

        return sm;
    }
}

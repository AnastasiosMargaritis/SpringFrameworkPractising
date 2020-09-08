package ssm.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import ssm.domain.Payment;
import ssm.domain.PaymentEvent;
import ssm.domain.PaymentState;
import ssm.repository.PaymentRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService service;

    @Autowired
    PaymentRepository repository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {

        Payment savedPayment = service.newPayment(payment);

        StateMachine<PaymentState, PaymentEvent> sm = service.preAuth(savedPayment.getId());

        Payment preAuthedPayment = repository.getOne(savedPayment.getId());

        System.out.println(sm.getState().getId());
    }

    @Transactional
    @RepeatedTest(10)
    void testAuth(){

        Payment savedPayment = service.newPayment(payment);

        StateMachine<PaymentState, PaymentEvent> preAuthSM = service.preAuth(savedPayment.getId());

        if(preAuthSM.getState().getId() == PaymentState.PRE_AUTH){
            System.out.println("Payment is Pre Authorized!");

            StateMachine<PaymentState, PaymentEvent> authSM = service.authorizePayment(savedPayment.getId());

            System.out.println("Result of auth is: " + authSM.getState().getId());

        } else {
            System.out.println("Payment failed pre-auth...");
        }
    }
}
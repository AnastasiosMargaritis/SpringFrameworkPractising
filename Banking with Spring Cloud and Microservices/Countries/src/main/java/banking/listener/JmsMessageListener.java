package banking.listener;

import banking.confg.JsmConfig;
import banking.domain.JmsMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class JmsMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JsmConfig.MY_QUEUE)
    public void listen(@Payload JmsMessage jmsMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I Got a Message!");
        System.out.println(jmsMessage);
    }

}

package banking.sender;

import banking.confg.JsmConfig;
import banking.domain.JmsMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    @Scheduled(fixedRate = 2000) // 2 seconds
    public void sendMessage(){
        JmsMessage message = JmsMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Gamw tis manas soy tin mounara.")
                .build();

        jmsTemplate.convertAndSend(JsmConfig.MY_QUEUE, message);
    }

}

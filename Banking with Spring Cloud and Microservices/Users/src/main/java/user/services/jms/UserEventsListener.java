package user.services.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import user.config.JsmConfig;
import user.domain.User;
import user.events.CountryUserEvent;
import user.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserEventsListener {

    private final UserRepository userRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JsmConfig.MY_QUEUE)
    public void listen(CountryUserEvent event){
        User dto = event.getUser();

        User user = userRepository.getOne(dto.getId());

        dto.setAccount(user.getAccount());

        NewAccountEvent accountEvent = new NewAccountEvent(user);

        jmsTemplate.convertAndSend(JsmConfig.NEW_ACCOUNT_EVENT, accountEvent);
    }
}

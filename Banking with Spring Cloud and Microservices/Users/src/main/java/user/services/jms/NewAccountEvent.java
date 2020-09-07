package user.services.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import user.domain.User;
import user.events.UserEvent;

@Slf4j
@Component
public class NewAccountEvent extends UserEvent {

    public NewAccountEvent(User user) {
        super(user);
    }
}

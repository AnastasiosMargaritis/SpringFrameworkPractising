package account.services.jms;

import account.domain.User;
import account.events.UserEvent;

public class NewAccountEvent extends UserEvent {


    public NewAccountEvent(User user) {
        super(user);
    }
}

package user.events;

import user.domain.User;

public class AccountUserEvent extends UserEvent{

    public AccountUserEvent(User user) {
        super(user);
    }
}

package account.events;

import account.domain.User;

public class AccountUserEvent extends UserEvent{

    public AccountUserEvent(User user) {
        super(user);
    }
}

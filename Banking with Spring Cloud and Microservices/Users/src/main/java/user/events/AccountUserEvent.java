package user.events;

import user.domain.User;

public class AccountUserEvent extends UserEvent{

    public AccountUserEvent(User userDto) {
        super(userDto);
    }
}

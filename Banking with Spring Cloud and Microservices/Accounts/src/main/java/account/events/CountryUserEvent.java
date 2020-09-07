package account.events;


import account.domain.User;

public class CountryUserEvent extends UserEvent {

    public CountryUserEvent(User user) {
        super(user);
    }
}

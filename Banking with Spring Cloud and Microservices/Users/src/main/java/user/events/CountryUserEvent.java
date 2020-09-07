package user.events;


import user.domain.User;


public class CountryUserEvent extends UserEvent {

    public CountryUserEvent(User user) {
        super(user);
    }
}

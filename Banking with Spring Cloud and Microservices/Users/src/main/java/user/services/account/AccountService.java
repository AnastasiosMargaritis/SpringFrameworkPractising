package user.services.account;

import user.domain.Account;
import user.domain.User;

public interface AccountService {

    Account generateNewAccount(User user);
}

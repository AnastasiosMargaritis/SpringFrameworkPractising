package account.services;

import account.domain.Account;
import account.domain.User;

import java.util.UUID;

public interface AccountService {

    Account generateNewAccount(User userDto);
    Account findAccountByUser(UUID id);
}

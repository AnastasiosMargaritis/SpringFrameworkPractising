package account.services;

import account.web.model.AccountDto;
import account.web.model.UserDto;

public interface AccountService {

    AccountDto generateNewAccount(UserDto userDto);
    AccountDto findAccountByUser(Long id);
}

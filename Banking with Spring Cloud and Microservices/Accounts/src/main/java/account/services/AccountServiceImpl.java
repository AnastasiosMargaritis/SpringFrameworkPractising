package account.services;

import account.domain.Account;
import account.repository.AccountRepository;
import account.repository.UserRepository;
import account.web.mappers.AccountMapper;
import account.web.mappers.UserMapper;
import account.web.model.AccountDto;
import account.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;

    @Override
    public AccountDto generateNewAccount(UserDto userDto) {
        Account account = new Account();
        account.setIban(account.generateIBAN());

        AccountDto accountDto = accountMapper.accountToAccountDto(this.accountRepository.save(account));
        userDto.setAccount(accountDto);

        this.userRepository.save(userMapper.userDtoToUser(userDto));

        return accountDto;
    }

    @Override
    public AccountDto findAccountByUser(Long id) {
        return null;
    }
}

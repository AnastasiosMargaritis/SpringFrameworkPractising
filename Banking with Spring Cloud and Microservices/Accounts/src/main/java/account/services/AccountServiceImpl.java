package account.services;

import account.domain.Account;
import account.domain.User;
import account.repository.AccountRepository;
import account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    @Override
    public Account generateNewAccount(User userDto) {
        Account account = new Account();
        account.setIban(account.generateIBAN());

        Account accountDto = this.accountRepository.save(account);
        userDto.setAccount(account);

        this.userRepository.save(userDto);

        return accountDto;
    }

    @Override
    public Account findAccountByUser(UUID id) {
        return null;
    }
}

package account.services.jms;

import account.config.JmsConfig;
import account.domain.Account;
import account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewAccountListener {

    private final AccountRepository accountRepository;


    @JmsListener(destination = JmsConfig.NEW_ACCOUNT_EVENT)
    public void listen(NewAccountEvent newAccountEvent){
        accountRepository.save(Account.builder()
                .id(newAccountEvent.getUser().getId())
                .money(newAccountEvent.getUser().getAccount().getMoney())
                .iban(newAccountEvent.getUser().getAccount().getIban())
                .user(newAccountEvent.getUser())
                .build());
    }
}

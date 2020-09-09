package user.services.transaction;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import user.repositories.UserRepository;
import user.web.model.AccountDto;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionValidator {

    private final UserRepository userRepository;

    public Boolean validateTransaction(AccountDto dto){

        Random random = new Random();

        if(random.nextInt(10) < 7){
            return true;
        }else {
            return false;
        }
    }

}

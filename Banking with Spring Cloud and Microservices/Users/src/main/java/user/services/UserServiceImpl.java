package user.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.domain.Account;
import user.domain.Country;
import user.domain.User;
import user.repositories.AccountRepository;
import user.repositories.CountryRepository;
import user.repositories.UserRepository;
import user.services.account.AccountService;
import user.services.country.CountryService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final CountryService countryService;
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public User createNewUser(User user) {

        Country country = countryService.getCountryByCode(user.getCountryCode());
        Account account = accountService.generateNewAccount(user);

        if(countryRepository.findByName(country.getName()) == null){
           user.setCountry(countryRepository.save(country));
        }else {
            user.setCountry(countryRepository.findByName(country.getName()));
        }

        user.setAccount(this.accountRepository.save(account));

        return userRepository.save(user);


//        user.setCountry(countryRepository.findByName(country.getName()));
//        return mapper.userToUserDto(userRepository.save(user));

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

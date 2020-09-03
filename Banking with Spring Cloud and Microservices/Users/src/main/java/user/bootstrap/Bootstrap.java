package user.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user.domain.Country;
import user.domain.User;
import user.repositories.CountryRepository;
import user.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {


    private final UserRepository userRepository;
    private final CountryRepository countryRepository;


    @Override
    public void run(String... args) throws Exception {

        Country country = new Country();
        country.setId(1L);
        country.setAlpha2Code("GR");
        country.setAlpha3Code("GRC");
        country.setCurrencyCode("EUR");
        country.setCurrencyName("Euro");
        country.setName("Greece");

        Country country1 = new Country();
        country1.setId(2L);
        country1.setAlpha2Code("AF");
        country1.setAlpha3Code("AFG");
        country1.setCurrencyCode("AFN");
        country1.setCurrencyName("Afghan afghani");
        country1.setName("Afghanistan");

        this.countryRepository.save(country);
        this.countryRepository.save(country1);

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("1234");
        user.setMobileNumber("6982131395");
        user.setAddress("Taxiarhon 24, Nea Kerasia");
        user.setCountry(country);

        User user1 = new User();
        user1.setId(2L);
        user1.setUsername("Anthi");
        user1.setPassword("6789");
        user1.setMobileNumber("6984999092");
        user1.setAddress("Taxiarhon 24, Nea Kerasia");
        user1.setCountry(country);

        User user2 = new User();
        user2.setId(3L);
        user2.setUsername("ElMargar");
        user2.setPassword("2323");
        user2.setMobileNumber("6984990621");
        user2.setAddress("Taxiarhon 24, Nea Kerasia");
        user2.setCountry(country);

        User user3 = new User();
        user3.setId(4L);
        user3.setUsername("ManasToMni");
        user3.setPassword("9873");
        user3.setMobileNumber("6944357944");
        user3.setAddress("Opou ston diaolo 8elw");
        user3.setCountry(country1);

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        this.userRepository.saveAll(users);


    }
}

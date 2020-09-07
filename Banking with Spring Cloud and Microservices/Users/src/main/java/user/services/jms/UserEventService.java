package user.services.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import user.repositories.UserRepository;
import user.services.country.CountryService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventService {

    private final UserRepository userRepository;
    private final CountryService countryService;
    private final JmsTemplate jmsTemplate;

//    @Scheduled(fixedRate = 5000)//every 5 seconds
//    public void checkForUsersCountry(){
//
//        List<User> users = userRepository.findAll();
//
//        users.forEach(user -> {
//            String countryName = countryService.getCountryByCode(user.getCountryCode()).getName();
//
//            log.debug("Country name: " + countryName);
//
//            if(countryName.equals("Greece")){
//                jmsTemplate.convertAndSend(JsmConfig.MY_QUEUE, new CountryUserEvent(mapper.userToUserDto(user)));
//            }
//        });
//    }
}

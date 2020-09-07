package user.services.account;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.domain.Account;
import user.domain.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "sfg.account", ignoreUnknownFields = false)
@Service
public class AccountServiceImpl implements AccountService {

    private final String ACCOUNT_PATH = "/api/v1/account/new";
    private final RestTemplate restTemplate;

    private String accountServiceHost;


    public AccountServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setAccountServiceHost(String serviceHost){
        this.accountServiceHost = serviceHost;
    }

    @Override
    public Account generateNewAccount(User user) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        map.put( "address", user.getAddress());
        map.put("mobileNumber", user.getAddress());
        map.put("countryCode", user.getCountryCode());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        return restTemplate.postForObject(
                accountServiceHost + ACCOUNT_PATH,
                entity,
                Account.class
        );
    }
}

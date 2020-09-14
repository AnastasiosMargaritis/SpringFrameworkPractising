package Shop.Customer.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(@Value("${sfg.brewery.bar-user}")String barUser,
                                                                   @Value("${sfg.brewery.bar-password}")String barPassword){
        return new BasicAuthRequestInterceptor(barUser, barPassword);
    }
}

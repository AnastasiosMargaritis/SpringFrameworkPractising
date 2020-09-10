package gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRoutesConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/customer*", "/customer/*", "/customer/order/*")
                        .uri("http://localhost:8080")
                        .id("customer"))
                .route(r -> r.path("/bar*", "/bar/*", "/bar/oder/*", "/bar/order*")
                        .uri("http://localhost:8081")
                        .id("bar"))
                .build();
    }
}

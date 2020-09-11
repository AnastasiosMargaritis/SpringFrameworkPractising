package gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-discovery")
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r.path("/customer*", "/customer/*", "/customer/order/{segement}")
                        .uri("lb://customer-service")
                        .id("customer-service"))
                .route(r -> r.path("/bar*", "/bar/*", "/bar/order/{segement}", "/bar/drinks")
                        .filters(f -> f.circuitBreaker(c -> c.setName("orderFail")
                                                            .setFallbackUri("forward:/order-failover")
                                                            .setRouteId("order-failover")
                        ))
                        .uri("lb://bar-service")
                        .id("bar-service"))
                .route(r -> r.path("/order-failover/**")
                            .uri("lb://order-failover")
                            .id("inventory-failover-service"))
                .build();
    }
}

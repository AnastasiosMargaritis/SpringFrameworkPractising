package Shop.Inventory.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by jt on 3/14/20.
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(OrderHandler orderHandler){
        return route(GET("/order-failover").and(accept(MediaType.APPLICATION_JSON)),
                orderHandler::listOrder);
    }
}

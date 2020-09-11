package Shop.Inventory.web;


import Shop.Inventory.domain.Drink;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 3/14/20.
 */
@Component
public class OrderHandler {

    public Mono<ServerResponse> listOrder(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(
                        Drink.builder()
                                .id(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                                .quantity(999)
                                .type("Any Type!")
                                .price(new BigDecimal("0.00"))
                                .build()), Drink.class);
    }
}
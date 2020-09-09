package Shop.Bar.controller;

import Shop.Bar.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bar/")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;

    @GetMapping
    @RequestMapping("order/{drinkType}")
    public ResponseEntity<BigDecimal> order(@PathVariable String drinkType){
        return new ResponseEntity(barService.order(drinkType), HttpStatus.OK);
    }
}

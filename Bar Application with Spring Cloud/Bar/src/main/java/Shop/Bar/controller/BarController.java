package Shop.Bar.controller;

import Shop.Bar.domain.Drink;
import Shop.Bar.service.BarService;
import Shop.Bar.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/bar/")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;
    private final DrinkService drinkService;

    @GetMapping
    @RequestMapping("order/{drinkType}")
    public ResponseEntity<BigDecimal> order(@PathVariable String drinkType){
        return new ResponseEntity(barService.order(drinkType), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("drinks")
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return new ResponseEntity<>(drinkService.getAllDrinks(), HttpStatus.OK);
    }
}

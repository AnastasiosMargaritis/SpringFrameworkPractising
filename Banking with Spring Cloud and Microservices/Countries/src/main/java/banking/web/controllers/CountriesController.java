package banking.web.controllers;

import banking.services.CountryService;
import banking.web.models.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country/")
@RequiredArgsConstructor
public class CountriesController {

    private final CountryService countryService;

    @GetMapping
    @RequestMapping("name/{name}")
    public ResponseEntity<CountryDto> getCountryByName(@PathVariable String name){
        return new ResponseEntity<>(countryService.getCountryByName(name), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("code/{code}")
    public ResponseEntity<CountryDto> getCountryByCode(@PathVariable String code){
        return new ResponseEntity<>(countryService.getCountryByCode(code), HttpStatus.OK);
    }
}

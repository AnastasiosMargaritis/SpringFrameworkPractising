package banking.domain;

import lombok.Data;

import java.util.List;

@Data
public class Country {
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    List<Currencies> currencies;
}
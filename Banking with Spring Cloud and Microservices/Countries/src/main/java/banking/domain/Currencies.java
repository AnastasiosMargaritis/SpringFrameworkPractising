package banking.domain;

import lombok.Data;

@Data
public class Currencies {
    private String code;
    private String name;
    private String symbol;
}
package com.banking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty("amount")
    private Date date;

    @JsonProperty("time")
    private  Double amount;
}

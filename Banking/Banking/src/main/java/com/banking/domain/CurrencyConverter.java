package com.banking.domain;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConverter {

    private String from;
    private String to;
    private Double amount;


    public void sendPost() throws Exception {
        HttpResponse<JsonNode> response = Unirest.get("https://currency13.p.rapidapi.com/convert/" + this.amount.toString() + "/" + this.from + "/" + this.to)
                .header("x-rapidapi-host", "currency13.p.rapidapi.com")
                .header("x-rapidapi-key", "ccc2904157msh55e154cca8d15f4p1badefjsnc16f791973c6")
                .asJson();

        JSONObject jsObject = response.getBody().getObject();
        System.out.println(jsObject.get("amount"));

    }

}

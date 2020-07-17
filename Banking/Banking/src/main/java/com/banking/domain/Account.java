package com.banking.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String iban;

    private HashMap<String, Double> money = new HashMap<>();

    private HashMap<String, Boolean> activatedCurrencies = new HashMap<>();

    @ManyToMany
    private List<Currencies> currencies = new ArrayList<>();

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

    public String generateIBAN(){
        final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        final String NUMBER = "0123456789";
        Random random = new Random();

        String generatedIban = "";

        StringBuilder sb = new StringBuilder(24);

        for(int i = 0; i < 24; i++){
            if(i % 4 == 0 && i > 0){
                sb.append(" ");
            }else{

                if(i < 2){
                    int rand = random.nextInt(CHAR_UPPER.length());
                    char r = CHAR_UPPER.charAt(rand);
                    sb.append(r);
                }else{
                    int rand = random.nextInt(NUMBER.length());
                    char r = NUMBER.charAt(rand);
                    sb.append(r);
                }

            }
        }
       return sb.toString();
    }

    public void initializeAccount(List<Currencies> currencies){

        for(Currencies c: currencies){
            this.money.put(c.getCurrency(), 0d);
            this.activatedCurrencies.put(c.getCurrency(), false);
        }
    }
}

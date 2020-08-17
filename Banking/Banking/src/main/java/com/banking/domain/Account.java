package com.banking.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
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

    @Lob
    private HashMap<String, Double> money = new HashMap<>();

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

    public String generateIBAN(){
        String iban = "GB78 REVO ";
        String digits = "0123456789";
        Random random = new Random();

        for(int i = 1; i <= 14; i++){

            if(i % 5 == 0 && i > 0){
                iban += " ";
            }else{

                iban += digits.charAt(random.nextInt(10));
            }
        }
        return iban;
    }
}

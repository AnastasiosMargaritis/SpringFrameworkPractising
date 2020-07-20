package com.banking.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

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

    @NotNull
    private String base;

    @Lob
    private HashMap<String, Double> money = new HashMap<>();

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

    public String generateIBAN(){
        return null;
    }

    public void initializeAccount(){

    }
}

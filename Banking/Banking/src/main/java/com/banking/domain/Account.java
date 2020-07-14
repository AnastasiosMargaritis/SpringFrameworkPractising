package com.banking.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 34, max = 34)
    private String iban;

    private HashMap<String, Double> money = new HashMap<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Currencies> currencies;

    @OneToOne(mappedBy = "account")
    private User user;
}

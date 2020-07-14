package com.banking.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Currencies{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double rate;

    @NotNull
    @Size(min = 3, max = 3)
    private String currency;

    @ManyToMany
    @JsonIgnore
    private List<Account> account = new ArrayList<>();

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;
}

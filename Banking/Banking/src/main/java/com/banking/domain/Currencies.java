package com.banking.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


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

    @ManyToOne
    @JoinColumn(name = "CUR")
    private Account account;

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;
}

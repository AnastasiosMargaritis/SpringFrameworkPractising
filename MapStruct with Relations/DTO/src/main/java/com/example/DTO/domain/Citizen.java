package com.example.DTO.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "citizen")
public class Citizen{

    @Id
    @GeneratedValue
    public Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String telephone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

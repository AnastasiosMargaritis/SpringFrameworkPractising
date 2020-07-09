package com.insta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follows_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private User from;

    @ManyToOne
    @JoinColumn(name = "to_user")
    private User to;

    private LocalDate created_at;
}

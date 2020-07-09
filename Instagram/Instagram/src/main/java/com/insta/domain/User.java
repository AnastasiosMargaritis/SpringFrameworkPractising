package com.insta.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private LocalDate created_at;

    @OneToMany(mappedBy = "user")
    private Set<Photos> photos;

    @OneToMany(mappedBy = "user")
    private Set<Comments> comments;

    @OneToMany(mappedBy = "user")
    private Set<Likes> likes;

    @OneToMany(mappedBy = "to")
    private List<Follows> followers;

    @OneToMany(mappedBy = "from")
    private List<Follows> following;
}

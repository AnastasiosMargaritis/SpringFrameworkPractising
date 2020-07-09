package com.insta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photos_id")
    private Long id;

    private String url;

    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "photos")
    private Set<Comments> comments;

    @OneToMany(mappedBy = "photos")
    private Set<Likes> likes;

    @OneToMany(mappedBy = "photos")
    private Set<Photo_Tags> photo_tags;

}

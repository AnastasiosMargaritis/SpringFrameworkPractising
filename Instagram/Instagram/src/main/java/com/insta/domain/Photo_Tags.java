package com.insta.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Photo_Tags {

    @ManyToOne
    @JoinColumn(name = "photo")
    private  Photos photos;

    @OneToMany(mappedBy = "tags")
    private Set<Tags> tags;
}

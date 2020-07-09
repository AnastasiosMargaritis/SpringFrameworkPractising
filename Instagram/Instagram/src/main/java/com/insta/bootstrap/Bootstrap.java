package com.insta.bootstrap;

import com.insta.domain.Follows;
import com.insta.domain.Likes;
import com.insta.domain.User;
import com.insta.repository.FollowsRepository;
import com.insta.repository.LikesRepository;
import com.insta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private FollowsRepository followsRepository;

    @Override
    public void run(String... args) throws Exception {

        User me = new User();
        me.setId(1L);
        me.setUsername("AnasMarg");
        me.setCreated_at(LocalDate.of(2017, 05, 07));

        User you = new User();
        you.setId(2L);
        you.setUsername("Shaggy");
        you.setCreated_at(LocalDate.of(2018, 11, 06));

        User he = new User();
        he.setId(3L);
        he.setUsername("Scooby");
        he.setCreated_at(LocalDate.of(2004, 8, 07));

        this.userRepository.save(me);
        this.userRepository.save(you);
        this.userRepository.save(he);

        Likes like = new Likes();
        like.setId(1L);
        like.setCreated_at(LocalDate.of(2020,05,07));
        like.setUser(me);

        Likes likes = new Likes();
        likes.setId(2L);
        likes.setCreated_at(LocalDate.of(2019, 07,14));
        likes.setUser(me);

        Likes youLike =  new Likes();
        youLike.setId(4L);
        youLike.setCreated_at(LocalDate.of(2000,11,14));
        youLike.setUser(you);

        this.likesRepository.save(like);
        this.likesRepository.save(likes);
        this.likesRepository.save(youLike);


        Follows follows = new Follows();
        follows.setId(1L);
        follows.setFrom(me);
        follows.setTo(you);
        follows.setCreated_at(LocalDate.of(2017,05,07));

        Follows follows1 = new Follows();
        follows1.setId(2L);
        follows1.setFrom(you);
        follows1.setTo(me);
        follows1.setCreated_at(LocalDate.of(2017,07,05));

        this.followsRepository.save(follows);
        this.followsRepository.save(follows1);

    }
}

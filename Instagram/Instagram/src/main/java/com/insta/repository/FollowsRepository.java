package com.insta.repository;

import com.insta.domain.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowsRepository extends JpaRepository<Follows, Long> {
}

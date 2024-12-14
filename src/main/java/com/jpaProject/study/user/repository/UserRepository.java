package com.jpaProject.study.user.repository;

import com.jpaProject.study.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

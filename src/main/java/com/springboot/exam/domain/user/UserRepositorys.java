package com.springboot.exam.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositorys extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

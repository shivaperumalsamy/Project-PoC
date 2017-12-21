package com.sirius.security.securitydbexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirius.security.securitydbexample.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}

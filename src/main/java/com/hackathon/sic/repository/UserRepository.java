package com.hackathon.sic.repository;

import java.util.Optional;

import com.hackathon.sic.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}

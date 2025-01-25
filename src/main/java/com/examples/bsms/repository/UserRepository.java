package com.examples.bsms.repository;

import com.examples.bsms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {

   public Optional<User> findByEmail(String email);
}

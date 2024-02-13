package com.nyc.sgibo.registrationloginsgibox1.repository;

import com.nyc.sgibo.registrationloginsgibox1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

package com.nyc.sgibo.registrationloginsgibox1.repository;

import com.nyc.sgibo.registrationloginsgibox1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

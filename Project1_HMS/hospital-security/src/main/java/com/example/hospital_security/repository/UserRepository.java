package com.example.hospital_security.repository;

import com.example.hospital_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);
}

package com.Ration_radar.Ration_radar.repository;

import com.Ration_radar.Ration_radar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

package com.scaler.usermanagementservice.repositories;

import com.scaler.usermanagementservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
}

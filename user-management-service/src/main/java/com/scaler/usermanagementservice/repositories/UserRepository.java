package com.scaler.usermanagementservice.repositories;

import com.scaler.usermanagementservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long user_id);
    boolean existsByEmail(String email);

    @Override
    void delete(User entity);
}

package com.scaler.usermanagementservice.repositories;

import com.scaler.usermanagementservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long user_id);
    boolean existsByEmail(String email);

    @Override
    void delete(User entity);

    boolean existsByUsername(String username);
}

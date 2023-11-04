package com.scaler.adminmanagementservice.repository;


import com.scaler.adminmanagementservice.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user u where u.role=0", nativeQuery = true)
    List<User> findAllAdmins();
}

package com.scaler.grievancemanagementservice.repositories;

import com.scaler.grievancemanagementservice.models.Grievance;
import com.scaler.grievancemanagementservice.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long>{

    List<Grievance> findAllByCreatedBy(User createdBy);

    @Override
    Page<Grievance> findAll(Pageable pageable);
}

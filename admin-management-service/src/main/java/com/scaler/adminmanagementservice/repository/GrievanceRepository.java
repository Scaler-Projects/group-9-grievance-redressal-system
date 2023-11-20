package com.scaler.adminmanagementservice.repository;

import com.scaler.adminmanagementservice.modals.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

    List<Grievance> findAllByAssigneeIsNotNull();

}

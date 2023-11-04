package com.scaler.grievancemanagementservice.controllers;

import com.scaler.grievancemanagementservice.models.Grievance;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/grievances")
public interface GrievanceOperations {

    @GetMapping("/")
    List<Grievance> getAll();

    @GetMapping("/{id}")
    Optional<Grievance> getById(@PathVariable Long id);

    @PostMapping("/{id}")
    public void save(@RequestBody Grievance grievance, @PathVariable Long id);

    @DeleteMapping("/{id}")
    Optional<Grievance> deleteById(@PathVariable Long id);

    @PutMapping("/{id}")
    Optional<Grievance> updateById(@RequestBody Grievance grievance, @PathVariable Long id);


}

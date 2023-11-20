package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.AssignedGrievanceResponseDto;
import com.scaler.adminmanagementservice.dtos.GrievanceRequestDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admins/grievances")
public interface AdminGrievanceOperations {


    @PutMapping()
    ResponseEntity<AssignedGrievanceResponseDto> assignGrievance(@RequestBody GrievanceRequestDto request) throws NotFoundException;

    @GetMapping()
    List<AssignedGrievanceResponseDto> getAssignedGrievances() throws NotFoundException;


}

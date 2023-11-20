package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.AssignedGrievanceResponseDto;
import com.scaler.adminmanagementservice.dtos.GrievanceRequestDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import com.scaler.adminmanagementservice.services.AdminGrievanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminGrievanceController implements AdminGrievanceOperations {

    private final AdminGrievanceService adminGrievanceService;

    public AdminGrievanceController(AdminGrievanceService adminGrievanceService) {
        this.adminGrievanceService = adminGrievanceService;
    }


    @Override
    public ResponseEntity<AssignedGrievanceResponseDto> assignGrievance(GrievanceRequestDto request) throws NotFoundException {
        return new ResponseEntity<>(adminGrievanceService.assignGrievance(request), HttpStatus.OK);
    }

    @Override
    public List<AssignedGrievanceResponseDto> getAssignedGrievances() throws NotFoundException {
        return adminGrievanceService.getAssignedGrievances();
    }
}

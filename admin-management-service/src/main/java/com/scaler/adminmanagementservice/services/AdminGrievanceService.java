package com.scaler.adminmanagementservice.services;

import com.scaler.adminmanagementservice.dtos.AssignedGrievanceResponseDto;
import com.scaler.adminmanagementservice.dtos.GrievanceRequestDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;

import java.util.List;

public interface AdminGrievanceService {

    AssignedGrievanceResponseDto assignGrievance(GrievanceRequestDto grievanceRequestDto) throws NotFoundException;

    List<AssignedGrievanceResponseDto> getAssignedGrievances() throws NotFoundException;
}

package com.scaler.analyticsservice.services.serviceinterfaces;

import com.scaler.analyticsservice.dtos.responses.GrievanceResponseDto;
import com.scaler.analyticsservice.dtos.responses.GrievanceStatusResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;

import java.util.List;

public interface AnalyticsService {
    List<GrievanceResponseDto> getAllGrievances() throws NotFoundException;
    List<GrievanceResponseDto> getGrievancesByStatus(String status) throws NotFoundException;
    GrievanceStatusResponseDto getGrievancesByStatusWiseCount() throws NotFoundException;
}

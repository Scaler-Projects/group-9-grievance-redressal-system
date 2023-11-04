package com.scaler.analyticsservice.services;

import com.scaler.analyticsservice.dtos.responses.GrievanceResponseDto;
import com.scaler.analyticsservice.dtos.responses.GrievanceStatusResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import com.scaler.analyticsservice.services.serviceinterfaces.AnalyticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Override
    public List<GrievanceResponseDto> getAllGrievances() throws NotFoundException {
        return null;
    }

    @Override
    public List<GrievanceResponseDto> getGrievancesByStatus(String status) throws NotFoundException {
        return null;
    }

    @Override
    public GrievanceStatusResponseDto getGrievancesByStatusWiseCount() throws NotFoundException {
        return null;
    }
}

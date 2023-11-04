package com.scaler.analyticsservice.controllers;

import com.scaler.analyticsservice.controllers.controllerinterfaces.Analytics;
import com.scaler.analyticsservice.dtos.responses.GrievanceResponseDto;
import com.scaler.analyticsservice.dtos.responses.GrievanceStatusResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController implements Analytics {

    @Override
    public List<GrievanceResponseDto> getAllGrievance() throws NotFoundException {
        return null;
    }

    @Override
    public List<GrievanceResponseDto> getGrievanceByStatus(String status) throws NotFoundException {
        return null;
    }

    @Override
    public List<GrievanceResponseDto> getGrievanceByFromAndToDate(Date fromDate, Date toDate) throws NotFoundException {
        return null;
    }

    @Override
    public Optional<GrievanceStatusResponseDto> getGrievanceStatusWiseCount() throws NotFoundException {
        return Optional.empty();
    }
}

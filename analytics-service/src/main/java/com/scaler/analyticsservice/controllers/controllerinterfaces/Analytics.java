package com.scaler.analyticsservice.controllers.controllerinterfaces;

import com.scaler.analyticsservice.dtos.responses.GrievanceResponseDto;
import com.scaler.analyticsservice.dtos.responses.GrievanceStatusResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/analytics")
public interface Analytics {
    @GetMapping()

    List<GrievanceResponseDto> getAllGrievance() throws NotFoundException;
    @GetMapping("/{status}")
    List<GrievanceResponseDto> getGrievanceByStatus(@PathVariable String status) throws NotFoundException;
    @GetMapping("/{fromDate}/{toDate}")
    List<GrievanceResponseDto> getGrievanceByFromAndToDate(@PathVariable Date fromDate,@PathVariable Date toDate) throws NotFoundException;

    @GetMapping("/status")
    Optional<GrievanceStatusResponseDto> getGrievanceStatusWiseCount() throws NotFoundException;
}


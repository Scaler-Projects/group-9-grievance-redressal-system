package com.scaler.grievancemanagementservice.controllers;

import com.scaler.grievancemanagementservice.dtos.GrievanceRequestDto;
import com.scaler.grievancemanagementservice.dtos.GrievanceResponseDto;
import com.scaler.grievancemanagementservice.services.GrievanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/grievances")
@RequiredArgsConstructor
public class GrievanceController implements GrievanceOperations{

    public final GrievanceService grievanceService;

    @Override
    public List<GrievanceResponseDto> getAllGrievancesByPage( Integer pageNo, Integer pageSize) {
        return grievanceService.getAllGrievancesPaginated(pageNo,pageSize);
    }

    @Override
    public GrievanceResponseDto getGrievanceById(Long id) {
        return grievanceService.getGrievanceById(id);
    }

    @Override
    public ResponseEntity<GrievanceResponseDto> createGrievance(GrievanceRequestDto grievance) {
        return new ResponseEntity<>(grievanceService.createGrievance(grievance), HttpStatus.CREATED);
    }

    @Override
    public void deleteById(Long id) {
        grievanceService.deleteGrievance(id);
    }

    @Override
    public GrievanceResponseDto update(GrievanceRequestDto grievanceRequestDto, Long id){
        return grievanceService.updateGrievance(grievanceRequestDto,id);
    }
}

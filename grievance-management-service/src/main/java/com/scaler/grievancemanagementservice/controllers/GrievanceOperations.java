package com.scaler.grievancemanagementservice.controllers;

import com.scaler.grievancemanagementservice.dtos.GrievanceRequestDto;
import com.scaler.grievancemanagementservice.dtos.GrievanceResponseDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
@RequestMapping("/grievances")
public interface GrievanceOperations {

    @GetMapping("/")
    List<GrievanceResponseDto> getAllGrievancesByPage(@RequestParam(value = "page_no", required = true) Integer pageNo,
                                                @RequestParam(value = "page_size", required = true) Integer pageSize);

    @GetMapping("/{id}")
    GrievanceResponseDto getGrievanceById(@PathVariable Long id);

    @PostMapping("/")
    ResponseEntity<GrievanceResponseDto> createGrievance(@RequestBody GrievanceRequestDto grievanceRequestDto);


    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @PutMapping("/{id}")
    GrievanceResponseDto update(@RequestBody GrievanceRequestDto grievanceRequestDto, @PathVariable Long id);


}

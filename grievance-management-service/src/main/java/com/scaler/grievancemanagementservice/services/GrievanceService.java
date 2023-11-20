package com.scaler.grievancemanagementservice.services;


import com.scaler.grievancemanagementservice.dtos.GrievanceRequestDto;
import com.scaler.grievancemanagementservice.dtos.GrievanceResponseDto;

import java.util.List;

public interface GrievanceService {

     GrievanceResponseDto createGrievance(GrievanceRequestDto grievanceRequestDto);
     GrievanceResponseDto updateGrievance(GrievanceRequestDto grievanceRequestDto,Long id);
     void deleteGrievance(Long id);
     GrievanceResponseDto getGrievanceById(Long id);
     List<GrievanceResponseDto> getAllGrievancesPaginated(int pageNo, int pageSize);

     List<GrievanceResponseDto> getAllGrievancesByUserId(Long id);


}

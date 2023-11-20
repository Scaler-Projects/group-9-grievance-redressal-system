package com.scaler.grievancemanagementservice.services;

import com.scaler.grievancemanagementservice.dtos.GrievanceRequestDto;
import com.scaler.grievancemanagementservice.dtos.GrievanceResponseDto;
import com.scaler.grievancemanagementservice.models.Grievance;
import com.scaler.grievancemanagementservice.models.GrievanceStatus;
import com.scaler.grievancemanagementservice.models.User;
import com.scaler.grievancemanagementservice.repositories.GrievanceRepository;
import com.scaler.grievancemanagementservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrievanceServiceImpl implements GrievanceService{

    private final GrievanceRepository grievanceRepository;
    private final UserRepository userRepository;

    @Override
    public GrievanceResponseDto createGrievance(GrievanceRequestDto grievanceRequestDto) {
        Grievance grievance = Grievance.builder()
                .title(grievanceRequestDto.getGrievanceTitle())
                .description(grievanceRequestDto.getGrievanceDescription())
                .status(GrievanceStatus.PENDING)
                .build();
        Grievance savedGrievance = grievanceRepository.save(grievance);
        return convertGrievanceToGrievanceResponseDto(savedGrievance);
    }

    @Override
    public GrievanceResponseDto updateGrievance(GrievanceRequestDto grievanceRequestDto,Long id) {
        Optional<Grievance> grievanceOptional = grievanceRepository.findById(id);
        if(grievanceOptional.isPresent()){
            Grievance grievance = grievanceOptional.get();
            grievance.setTitle(grievanceRequestDto.getGrievanceTitle());
            grievance.setDescription(grievanceRequestDto.getGrievanceDescription());
            Grievance updatedGrievance = grievanceRepository.save(grievance);
            return convertGrievanceToGrievanceResponseDto(updatedGrievance) ;
        }else{
            return null;
        }
    }

    @Override
    public void deleteGrievance(Long id) {
        grievanceRepository.deleteById(id);
    }

    @Override
    public GrievanceResponseDto getGrievanceById(Long id) {
        Optional<Grievance> grievance = grievanceRepository.findById(id);
        return grievance.map(this::convertGrievanceToGrievanceResponseDto).orElse(null);
    }
    @Override
    public List<GrievanceResponseDto> getAllGrievancesPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Grievance> grievances = grievanceRepository.findAll(pageable);
        return grievances.stream().map(this::convertGrievanceToGrievanceResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<GrievanceResponseDto> getAllGrievancesByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            return null;
        }

        List<Grievance> grievances = grievanceRepository.findAllByCreatedBy(user.get());
        return grievances.stream().map(this::convertGrievanceToGrievanceResponseDto).collect(Collectors.toList());
    }

    public GrievanceResponseDto convertGrievanceToGrievanceResponseDto(Grievance grievance){
        return GrievanceResponseDto.builder()
                .grievanceId(grievance.getId())
                .grievanceDescription(grievance.getDescription())
                .grievanceTitle(grievance.getTitle())
                .grievanceStatus(grievance.getStatus().toString())
                .build();
    }
}

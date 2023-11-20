package com.scaler.adminmanagementservice.services;

import com.scaler.adminmanagementservice.dtos.AssignedGrievanceResponseDto;
import com.scaler.adminmanagementservice.dtos.GrievanceRequestDto;
import com.scaler.adminmanagementservice.exceptions.NotFoundException;
import com.scaler.adminmanagementservice.helper.ConvertTime;
import com.scaler.adminmanagementservice.modals.Grievance;
import com.scaler.adminmanagementservice.modals.Status;
import com.scaler.adminmanagementservice.repository.GrievanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminGrievanceServiceImplementation implements AdminGrievanceService {

    private final GrievanceRepository grievanceRepository;

    public AdminGrievanceServiceImplementation(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    private AssignedGrievanceResponseDto convertToAssignGrievanceResponseDto(Grievance grievance) {
        AssignedGrievanceResponseDto responseDto = new AssignedGrievanceResponseDto();
        responseDto.setId(grievance.getGrievance_id());
        responseDto.setDescription(grievance.getDescription());
        responseDto.setAssignee(grievance.getAssignee());
        responseDto.setCreated_by(grievance.getCreated_by());
        responseDto.setUpdated_by(grievance.getUpdated_by());
        responseDto.setTimeUpdated(grievance.getTimeUpdated());
        responseDto.setTimeCreated(grievance.getTimeCreated());
        responseDto.setStatus(grievance.getStatus());

        return responseDto;
    }

    private AssignedGrievanceResponseDto getAssignedGrievanceResponseDto(Grievance g) {
        AssignedGrievanceResponseDto assignedGrievanceResponseDto = new AssignedGrievanceResponseDto();

        assignedGrievanceResponseDto.setId(g.getGrievance_id());
        assignedGrievanceResponseDto.setDescription(g.getDescription());
        assignedGrievanceResponseDto.setStatus(g.getStatus());
        assignedGrievanceResponseDto.setAssignee(g.getAssignee());
        assignedGrievanceResponseDto.setTimeCreated(g.getTimeCreated());
        assignedGrievanceResponseDto.setCreated_by(g.getCreated_by());
        assignedGrievanceResponseDto.setTimeUpdated(g.getTimeUpdated());
        assignedGrievanceResponseDto.setUpdated_by(g.getUpdated_by());
        return assignedGrievanceResponseDto;
    }


    @Override
    public AssignedGrievanceResponseDto assignGrievance(GrievanceRequestDto grievanceRequestDto) throws NotFoundException {
        Optional<Grievance> grievance = this.grievanceRepository.findById(grievanceRequestDto.getGrievance_id());
        if (grievance.isPresent()) {
            Grievance newGrievance = grievance.get();
            newGrievance.setAssignee(grievanceRequestDto.getAssignee_id());
            newGrievance.setUpdated_by(grievanceRequestDto.getAssignee_id());
            newGrievance.setStatus(Status.ASSIGN);
            newGrievance.setTimeUpdated(ConvertTime.localDateTimeToLong(LocalDateTime.now()));

            this.grievanceRepository.save(newGrievance);

            return convertToAssignGrievanceResponseDto(newGrievance);
        }
        throw new NotFoundException("Grievance with id: " + grievanceRequestDto.getGrievance_id() + " not exist");


    }

    @Override
    public List<AssignedGrievanceResponseDto> getAssignedGrievances() throws NotFoundException {
        List<AssignedGrievanceResponseDto> responseDtos = new ArrayList<>();
        List<Grievance> grievances = grievanceRepository.findAllByAssigneeIsNotNull();


        if (!grievances.isEmpty()) {
            for (Grievance g : grievances) {
                AssignedGrievanceResponseDto assignedGrievanceResponseDto = getAssignedGrievanceResponseDto(g);

                responseDtos.add(assignedGrievanceResponseDto);

            }

            return responseDtos;
        }
        throw new NotFoundException("Not exist any assigned grievances");
    }


}

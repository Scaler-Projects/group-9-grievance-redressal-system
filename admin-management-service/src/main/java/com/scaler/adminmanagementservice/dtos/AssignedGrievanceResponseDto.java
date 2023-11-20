package com.scaler.adminmanagementservice.dtos;

import com.scaler.adminmanagementservice.modals.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignedGrievanceResponseDto {
    private Long id;
    private String description;
    private Long created_by;
    private Long assignee;
    private Long updated_by;
    private Status status;
    private Long timeCreated;
    private Long timeUpdated;
}

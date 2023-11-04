package com.scaler.analyticsservice.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GrievanceResponseDto {
    private  int id;
    private String description;
    private String assignedTo;
    private String status;
    private String createdBy;
    private String updatedBy;
    private Date createdAt;
    private Date updatedAt;
}

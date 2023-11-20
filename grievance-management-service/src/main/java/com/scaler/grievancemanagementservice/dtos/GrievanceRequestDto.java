package com.scaler.grievancemanagementservice.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class GrievanceRequestDto {
    private Long grievanceId;
    private String grievanceTitle;
    private String grievanceDescription;
    private String grievanceStatus;
}

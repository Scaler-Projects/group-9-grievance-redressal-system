package com.scaler.analyticsservice.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GrievanceStatusResponseDto {
    private Map<String,Integer> statusCount;
    private int totalCount;
}

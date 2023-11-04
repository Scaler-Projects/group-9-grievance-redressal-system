package com.scaler.analyticsservice.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NotificationResponseDto {
    private int id;
    private int grievanceId;
    private String previousState;
    private String newState;
    private String updatedBy;
    private String notifierUser;
    private Date notifiedAt;
}

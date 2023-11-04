package com.scaler.analyticsservice.services.serviceinterfaces;

import com.scaler.analyticsservice.dtos.responses.NotificationResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;

import java.util.List;

public interface DashboardService {
    List<NotificationResponseDto> getAllNotification() throws NotFoundException;
    List<NotificationResponseDto> getNotificationByAssignee(String assignee) throws NotFoundException;
    List<NotificationResponseDto> getAllNotificationByFromAndToDate(String fromDate, String toDate) throws NotFoundException;
}

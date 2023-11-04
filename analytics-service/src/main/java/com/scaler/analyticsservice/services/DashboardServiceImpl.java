package com.scaler.analyticsservice.services;

import com.scaler.analyticsservice.dtos.responses.NotificationResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import com.scaler.analyticsservice.services.serviceinterfaces.DashboardService;

import java.util.List;

public class DashboardServiceImpl implements DashboardService {
    @Override
    public List<NotificationResponseDto> getAllNotification() throws NotFoundException {
        return null;
    }

    @Override
    public List<NotificationResponseDto> getNotificationByAssignee(String assignee) throws NotFoundException {
        return null;
    }

    @Override
    public List<NotificationResponseDto> getAllNotificationByFromAndToDate(String fromDate, String toDate) throws NotFoundException {
        return null;
    }
}

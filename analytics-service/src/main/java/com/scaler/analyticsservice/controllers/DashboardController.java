package com.scaler.analyticsservice.controllers;

import com.scaler.analyticsservice.controllers.controllerinterfaces.Dashboard;
import com.scaler.analyticsservice.dtos.responses.NotificationResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/dashboard")
public class DashboardController implements Dashboard {
    @Override
    public List<NotificationResponseDto> getAllNotification() throws NotFoundException {
        return null;
    }

    @Override
    public List<NotificationResponseDto> getNotificationByAssignee(String assignee) throws NotFoundException {
        return null;
    }

    @Override
    public List<NotificationResponseDto> getAllNotificationByFromAndToDate(Date fromDate, Date toDate) throws NotFoundException {
        return null;
    }
}

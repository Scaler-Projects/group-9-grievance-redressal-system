package com.scaler.analyticsservice.controllers.controllerinterfaces;


import com.scaler.analyticsservice.dtos.responses.NotificationResponseDto;
import com.scaler.analyticsservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;



@RequestMapping("/dashboard")
public interface Dashboard {
    @GetMapping()
    List<NotificationResponseDto> getAllNotification() throws NotFoundException;
    @GetMapping("/{assignee}")
    List<NotificationResponseDto> getNotificationByAssignee(@PathVariable String assignee) throws NotFoundException;
    @GetMapping("/{fromDate}/{toDate}")
    List<NotificationResponseDto> getAllNotificationByFromAndToDate(@PathVariable Date fromDate, @PathVariable Date toDate) throws NotFoundException;

}

package com.scaler.analyticsservice.clientservice;

import com.scaler.analyticsservice.dtos.responses.GrievanceResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;


@Service
public class GrievanceServiceClient {
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${grievance.api.url}")
    private String grievanceApiUrl;

    @Value("${grievance.api.paths.grievance}")
    private String grievanceApiPath;

    private String grievanceRequestUrl ;
    private String grievanceRequestsBaseUrl ;

    public GrievanceServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${grievance.api.url}") String grievanceApiUrl,
                                         @Value("${grievance.api.paths.grievance}") String grievanceApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.grievanceRequestsBaseUrl  = grievanceApiUrl + grievanceApiPath;
        this.grievanceRequestUrl = grievanceApiUrl + grievanceApiPath + "/{id}";
    }
    public List<GrievanceResponseDto> getAllGrievances() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<GrievanceResponseDto> result = new ArrayList<>();
        ResponseEntity<GrievanceResponseDto[]> response =
                restTemplate.getForEntity(grievanceRequestsBaseUrl, GrievanceResponseDto[].class);

        //return Arrays.stream(response.getBody()).toList();
        return result;
    }
}

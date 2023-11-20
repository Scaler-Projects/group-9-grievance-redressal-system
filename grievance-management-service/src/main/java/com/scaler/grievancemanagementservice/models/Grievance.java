package com.scaler.grievancemanagementservice.models;

import lombok.*;

import javax.persistence.*;

@Entity(name = "grievances")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grievance extends BaseModel{

    private String title;

    private String description;

    @Enumerated(value = EnumType.ORDINAL)
    private GrievanceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;


}

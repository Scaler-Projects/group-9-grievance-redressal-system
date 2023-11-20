package com.scaler.adminmanagementservice.modals;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "grievances")
public class Grievance {
    @Id
    @GeneratedValue(generator = "idgenerator")
    @GenericGenerator(name = "idgenerator", strategy = "increment")
    private Long grievance_id;
    private String description;
//    @ManyToOne
    private Long created_by;
//    @ManyToOne
    private Long assignee;
//    @ManyToOne
    private Long updated_by;
    private Status status;
    private Long timeCreated;
    private Long timeUpdated;
}

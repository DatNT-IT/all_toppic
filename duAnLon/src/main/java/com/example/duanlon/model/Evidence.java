package com.example.duanlon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Evidence extends AbstractEntity{
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    @ManyToOne
    @JoinColumn(name = "criminal_case_id")
    private CriminalCase criminalCase;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
//    private Set<TrackEntry > trackEntries;

}

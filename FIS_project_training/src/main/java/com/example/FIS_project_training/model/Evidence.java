package com.example.FIS_project_training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evidence extends AbstractEntity {
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    private CriminalCase criminalCase;
    private Storage storage;
    private Set<TrackEntry> trackEntries;
}

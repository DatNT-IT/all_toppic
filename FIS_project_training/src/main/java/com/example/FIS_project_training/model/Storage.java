package com.example.FIS_project_training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage extends AbstractEntity {
    private String name;
    private String location;
    private Set<Evidence> evidenceSet;
}

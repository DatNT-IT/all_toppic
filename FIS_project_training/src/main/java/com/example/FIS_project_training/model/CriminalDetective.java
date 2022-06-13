package com.example.FIS_project_training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriminalDetective {
    private Long id;
    private CriminalCase criminalCase;
    private Detective detective;
}

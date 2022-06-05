package com.example.FIS_project_training.dao.criminal;

import com.example.FIS_project_training.model.CriminalCase;

public interface IDAOCriminal {
    public void createCriminalCase(CriminalCase criminalCase);
    public CriminalCase deleteCriminalCaseById(String id);
    public CriminalCase updateCriminalCase(CriminalCase criminalCase);

}

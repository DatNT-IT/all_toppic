package com.example.FIS_project_training.dao.detective;

import com.example.FIS_project_training.model.Detective;

public interface IDAODetective {
    public void createDetective(Detective detective);
    public Detective deleteDetectiveById(String id);
    public Detective updateDetective(Detective detective);
}

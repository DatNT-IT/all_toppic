package com.example.FIS_project_training.dao.evidence;

import com.example.FIS_project_training.model.Evidence;

public interface IDAOEvidence {

    public void createEvidence(Evidence evidence) ;

    public Evidence deleteEvidenceById(String id);

    public Evidence updateEvidence(Evidence evidence);

}

package com.example.duanlon.service;

import com.example.duanlon.core.CaseStatus;
import com.example.duanlon.core.CaseType;
import com.example.duanlon.model.CriminalCase;
import com.example.duanlon.model.Detective;
import com.example.duanlon.model.Evidence;

import java.util.Set;

public interface ICriminalCaseService extends IAbstractService<CriminalCase> {
    CriminalCase createCriminalCase(String number,CaseType type,
                                    String shortDescription, String detailedDescription,
                                    CaseStatus caseStatus, String notes,
                                    Set<Evidence> evidenceSet,
                                    Detective leadInvestigator);
}

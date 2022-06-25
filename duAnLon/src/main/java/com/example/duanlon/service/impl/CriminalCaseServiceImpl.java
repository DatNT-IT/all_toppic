package com.example.duanlon.service.impl;

import com.example.duanlon.core.CaseStatus;
import com.example.duanlon.core.CaseType;
import com.example.duanlon.model.CriminalCase;
import com.example.duanlon.model.Detective;
import com.example.duanlon.model.Evidence;
import com.example.duanlon.repository.ICriminalCaseRepository;
import com.example.duanlon.service.ICriminalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class CriminalCaseServiceImpl implements ICriminalCaseService {
    private ICriminalCaseRepository iCriminalCaseRepository;

    @Autowired
    public CriminalCaseServiceImpl(ICriminalCaseRepository iCriminalCaseRepository) {
        this.iCriminalCaseRepository = iCriminalCaseRepository;
    }

    @Override
    public void save(CriminalCase entity) {
        iCriminalCaseRepository.save(entity);
        log.info("Save CriminalCase : {}", entity);
    }

    @Override
    public CriminalCase findById(Long entityId) {
        return iCriminalCaseRepository.findById(entityId).get();
    }

    @Override
    public void delete(CriminalCase entity) {
        iCriminalCaseRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iCriminalCaseRepository.existsById(entityId);
        if (exist) {
            iCriminalCaseRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<CriminalCase> findAll() {
        return iCriminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase createCriminalCase(String number,CaseType type, String shortDescription, String detailedDescription, CaseStatus caseStatus, String notes, Set<Evidence> evidenceSet, Detective leadInvestigator) {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setNumber(number);
        criminalCase.setType(type);
        criminalCase.setDetailedDescription(detailedDescription);
        criminalCase.setShortDescription(shortDescription);
        criminalCase.setStatus(caseStatus);
        criminalCase.setNotes(notes);
        criminalCase.setEvidenceSet(evidenceSet);
        criminalCase.setLeadInvestigator(leadInvestigator);
        iCriminalCaseRepository.save(criminalCase);
        return criminalCase;
    }
}

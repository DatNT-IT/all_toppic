package com.example.duanlon.service.impl;

import com.example.duanlon.model.CriminalCase;
import com.example.duanlon.model.Evidence;
import com.example.duanlon.model.Storage;
import com.example.duanlon.model.TrackEntry;
import com.example.duanlon.repository.IEvidenceRepository;
import com.example.duanlon.service.IEvidenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class EvidenceServiceImpl implements IEvidenceService {
    private IEvidenceRepository iEvidenceRepository;

    @Autowired
    public EvidenceServiceImpl(IEvidenceRepository iEvidenceRepository) {
        this.iEvidenceRepository = iEvidenceRepository;
    }

    @Override
    public void save(Evidence entity) {
        iEvidenceRepository.save(entity);
        log.info("Save Evidence : {}", entity);

    }

    @Override
    public Evidence findById(Long entityId) {
        return iEvidenceRepository.findById(entityId).get();
    }

    @Override
    public void delete(Evidence entity) {
        iEvidenceRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iEvidenceRepository.existsById(entityId);
        if (exist) {
            iEvidenceRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<Evidence> findAll() {
        return iEvidenceRepository.findAll();
    }

    @Override
    public Evidence createEvidence(String number, String notes, Boolean archived, CriminalCase criminalCase,
                                   Storage storage, String itemName, Set<TrackEntry> trackEntries) {
        Evidence evidence = new Evidence();
        evidence.setNumber(number);
        evidence.setNotes(notes);
        evidence.setArchived(archived);
        evidence.setCriminalCase(criminalCase);
        evidence.setStorage(storage);
        evidence.setItemName(itemName);
        evidence.setTrackEntries(trackEntries);
        return evidence;
    }

    @Override
    public Set<Evidence> findByCriminalCase(CriminalCase criminalCase) {
        return iEvidenceRepository.findByCriminalCase(criminalCase);
    }

    @Override
    public Optional<Evidence> findByNumber(String evidenceNumber) {
        return iEvidenceRepository.findByNumber(evidenceNumber);
    }
}

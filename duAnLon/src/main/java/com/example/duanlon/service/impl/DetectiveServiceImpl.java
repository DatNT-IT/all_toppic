package com.example.duanlon.service.impl;

import com.example.duanlon.core.EmploymentStatus;
import com.example.duanlon.core.Rank;
import com.example.duanlon.model.CriminalCase;
import com.example.duanlon.model.Detective;
import com.example.duanlon.model.Person;
import com.example.duanlon.model.TrackEntry;
import com.example.duanlon.repository.IDetectiveRepository;
import com.example.duanlon.service.IDetectiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class DetectiveServiceImpl implements IDetectiveService {
    private IDetectiveRepository iDetectiveRepository;

    @Autowired
    public DetectiveServiceImpl(IDetectiveRepository iDetectiveRepository) {
        this.iDetectiveRepository = iDetectiveRepository;
    }

    @Override
    public void save(Detective entity) {
        iDetectiveRepository.save(entity);
        log.info("Save Detective : {}", entity);
    }

    @Override
    public Detective findById(Long entityId) {
        return iDetectiveRepository.findById(entityId).get();
    }

    @Override
    public void delete(Detective entity) {
iDetectiveRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iDetectiveRepository.existsById(entityId);
        if (exist) {
            iDetectiveRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<Detective> findAll() {
        return iDetectiveRepository.findAll();
    }

    @Override
    public Detective createDetective(Person person, Rank rank, String badgeNumber, Boolean armed,
                                     EmploymentStatus status, Set<CriminalCase> criminalCases,
                                     Set<TrackEntry> trackEntries) {
        Detective detective = new Detective();
        detective.setPerson(person);
        detective.setRank(rank);
        detective.setBadgeNumber(badgeNumber);
        detective.setArmed(armed);
        detective.setStatus(status);
        detective.setCriminalCases(criminalCases);
        detective.setTrackEntries(trackEntries);
        iDetectiveRepository.save(detective);
        return detective;
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        return iDetectiveRepository.findByBadgeNumber(badgeNumber);
    }

    @Override
    public Set<Detective> findByRank(Rank rank) {
        return findByRank(rank);
    }
}

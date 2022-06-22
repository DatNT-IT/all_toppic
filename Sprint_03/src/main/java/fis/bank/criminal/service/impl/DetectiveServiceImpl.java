package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.Detective;
import fis.bank.criminal.repository.DetectiveRepository;
import fis.bank.criminal.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    @Qualifier("extraDetectiveRepositoryImpl")
    DetectiveRepository detectiveRepository;

    @Override
    public Set<Detective> findALl() {
        return detectiveRepository.findAll();
    }

    @Override
    public Detective findById(Long detectiveId) {
        return detectiveRepository.findById(detectiveId);
    }

    @Override
    public void deleteById(Long detectiveId) {
        detectiveRepository.deleteById(detectiveId);
    }

    @Override
    public void save(Detective detective) {
        detectiveRepository.save(detective);
    }
}

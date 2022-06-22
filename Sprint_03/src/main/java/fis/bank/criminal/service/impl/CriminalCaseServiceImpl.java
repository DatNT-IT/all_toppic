package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.CriminalCase;
import fis.bank.criminal.repository.CriminalCaseRepository;
import fis.bank.criminal.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {

    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase findById(Long criminalCaseId) {
        Optional<CriminalCase> opt = criminalCaseRepository.findById(criminalCaseId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        criminalCaseRepository.save(criminalCase);
    }

    @Override
    public void deleteById(Long criminalCaseId) {
        criminalCaseRepository.deleteById(criminalCaseId);
    }

}

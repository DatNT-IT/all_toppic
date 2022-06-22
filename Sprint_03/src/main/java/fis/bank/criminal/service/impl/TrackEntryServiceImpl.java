package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.TrackEntry;
import fis.bank.criminal.repository.TrackEntryRepository;
import fis.bank.criminal.service.TrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackEntryServiceImpl implements TrackEntryService {

    @Autowired
    TrackEntryRepository trackEntryRepository;

    @Override
    public List<TrackEntry> findAll() {
        return trackEntryRepository.findAll();
    }

    @Override
    public TrackEntry findById(Long trackEntryId) {
        Optional<TrackEntry> opt = trackEntryRepository.findById(trackEntryId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public void save(TrackEntry trackEntry) {
        trackEntryRepository.save(trackEntry);
    }

    @Override
    public void deleteById(Long trackEntryId) {
        trackEntryRepository.deleteById(trackEntryId);
    }

}

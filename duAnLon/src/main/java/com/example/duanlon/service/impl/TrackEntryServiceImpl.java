package com.example.duanlon.service.impl;

import com.example.duanlon.model.TrackEntry;
import com.example.duanlon.repository.ITrackEntryRepository;
import com.example.duanlon.service.ITrackEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrackEntryServiceImpl implements ITrackEntryService {
  private ITrackEntryRepository iTrackEntryRepository;
@Autowired
    public TrackEntryServiceImpl(ITrackEntryRepository iTrackEntryRepository) {
        this.iTrackEntryRepository = iTrackEntryRepository;
    }

    @Override
    public void save(TrackEntry entity) {
        iTrackEntryRepository.save(entity);
    log.info("Save TrackEntry :{}",entity);
}

    @Override
    public TrackEntry findById(Long entityId) {
        return iTrackEntryRepository.findById(entityId).get();
    }

    @Override
    public void delete(TrackEntry entity) {
iTrackEntryRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iTrackEntryRepository.existsById(entityId);
        if (exist) {
            iTrackEntryRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<TrackEntry> findAll() {
        return iTrackEntryRepository.findAll();
    }
}

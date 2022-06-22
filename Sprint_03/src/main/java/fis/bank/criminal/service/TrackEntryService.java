package fis.bank.criminal.service;

import fis.bank.criminal.model.TrackEntry;

import java.util.List;

public interface TrackEntryService {
    List<TrackEntry> findAll();

    TrackEntry findById(Long trackEntryId);

    void save(TrackEntry trackEntry);

    void deleteById(Long trackEntryId);
}

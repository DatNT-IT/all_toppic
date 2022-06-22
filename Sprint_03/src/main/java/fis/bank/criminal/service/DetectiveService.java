package fis.bank.criminal.service;

import fis.bank.criminal.model.Detective;

import java.util.Set;

public interface DetectiveService {
    Set<Detective> findALl();

    Detective findById(Long detectiveId);

    void deleteById(Long detectiveId);

    void save(Detective detective);
}

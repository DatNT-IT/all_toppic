package fis.bank.criminal.service;

import fis.bank.criminal.model.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> findAll();

    Storage findById(Long storageId);

    void save(Storage storage);

    void deleteById(Long storageId);
}

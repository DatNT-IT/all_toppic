package com.example.duanlon.service.impl;

import com.example.duanlon.model.Storage;
import com.example.duanlon.repository.IStorageRepository;
import com.example.duanlon.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StorageServiceImpl implements IStorageService {
    private IStorageRepository iStorageRepository;

    @Autowired
    public StorageServiceImpl(IStorageRepository iStorageRepository) {
        this.iStorageRepository = iStorageRepository;
    }

    @Override
    public void save(Storage entity) {
iStorageRepository.save(entity);
        log.info("Save Storage : {}", entity);
    }

    @Override
    public Storage findById(Long entityId) {
        return iStorageRepository.findById(entityId).get();
    }

    @Override
    public void delete(Storage entity) {
iStorageRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iStorageRepository.existsById(entityId);
        if (exist) {
            iStorageRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<Storage> findAll() {
        return iStorageRepository.findAll();
    }

    @Override
    public Storage createStorage(String name, String location) {
        Storage storage = new Storage();
        storage.setName(name);
        storage.setLocation(location);
        iStorageRepository.save(storage);
        return storage;
    }

    @Override
    public Optional<Storage> findByName(String name) {
        return iStorageRepository.findByName(name);
    }

    @Override
    public Optional<Storage> findByLocation(String location) {
        return iStorageRepository.findByLocation(location);
    }
}

package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.Storage;
import fis.bank.criminal.repository.StorageRepository;
import fis.bank.criminal.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageRepository storageRepository;

    @Override
    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    @Override
    public Storage findById(Long storageId) {
        Optional<Storage> opt = storageRepository.findById(storageId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public void save(Storage storage) {
        storageRepository.save(storage);
    }

    @Override
    public void deleteById(Long storageId) {
        storageRepository.deleteById(storageId);
    }

}

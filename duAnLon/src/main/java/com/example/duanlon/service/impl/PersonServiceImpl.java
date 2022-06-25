package com.example.duanlon.service.impl;

import com.example.duanlon.model.Person;
import com.example.duanlon.repository.IPersonRepository;
import com.example.duanlon.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PersonServiceImpl implements IPersonService {
   private IPersonRepository iPersonRepository;
@Autowired
    public PersonServiceImpl(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    @Override
    public void save(Person entity) {
        iPersonRepository.save(entity);
        log.info("Save Person : {}", entity);
    }

    @Override
    public Person findById(Long entityId) {
        return iPersonRepository.findById(entityId).get();
    }

    @Override
    public void delete(Person entity) {
iPersonRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        boolean exist = iPersonRepository.existsById(entityId);
        if (exist) {
            iPersonRepository.deleteById(entityId);
        }
    }

    @Override
    public Iterable<Person> findAll() {
        return iPersonRepository.findAll();
    }
}

package com.example.duanlon.service;

import com.example.duanlon.model.Storage;

import java.util.Optional;

public interface IStorageService extends IAbstractService<Storage>{
    Storage createStorage(String name, String location);
    Optional<Storage> findByName(String name);
    Optional<Storage> findByLocation(String location);
}

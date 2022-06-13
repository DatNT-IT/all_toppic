package com.example.FIS_project_training.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    T save(T t);
    Optional<T> findById(Long id);
    List<T> findAll();
    void update(T t);
    T delete(T t);
}

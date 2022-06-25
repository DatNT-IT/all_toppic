package com.example.duanlon.service;

public interface IAbstractService<T>{
    void save(T entity);
    T findById(Long entityId);
    void delete(T entity);
    void deleteById(Long entityId);
    Iterable<T> findAll();
}

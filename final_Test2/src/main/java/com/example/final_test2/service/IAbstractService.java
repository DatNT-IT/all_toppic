package com.example.final_test2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAbstractService<T> {
    T create(T entity);

    T findById(Long id);

    void delete(Long id);

    Page<T> findAll(Pageable pageable);

    T update(T entity);
}

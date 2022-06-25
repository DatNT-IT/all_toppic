package com.example.duanlon.repository;

import com.example.duanlon.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICriminalCaseRepository extends JpaRepository<CriminalCase,Long> {
}

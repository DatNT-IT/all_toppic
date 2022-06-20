package com.example.duanlon.repository;

import com.example.duanlon.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase,Long> {
}

package com.example.duanlon.service;

import com.example.duanlon.core.EmploymentStatus;
import com.example.duanlon.core.Rank;
import com.example.duanlon.model.CriminalCase;
import com.example.duanlon.model.Detective;
import com.example.duanlon.model.Person;
import com.example.duanlon.model.TrackEntry;

import java.util.Optional;
import java.util.Set;

public interface IDetectiveService extends IAbstractService<Detective>{
    Detective createDetective(Person person, Rank rank, String badgeNumber, Boolean armed, EmploymentStatus status,
                              Set<CriminalCase> criminalCases, Set<TrackEntry> trackEntries);
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    Set<Detective> findByRank(Rank rank);
}

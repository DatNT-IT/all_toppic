package com.example.duanlon.model;

import com.example.duanlon.Core.EmploymentStatus;
import com.example.duanlon.Core.Rank;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Detective extends AbstractEntity{
    @NotNull
    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String badgeNumber;
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed = false;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status = EmploymentStatus.ACTIVE;
    @ManyToMany
    @JoinTable(
            name="detective_case",
            joinColumns=@JoinColumn(name="detective_id",
                    referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="case_id",
                    referencedColumnName="id"))
    private Set<CriminalCase> criminalCases;
    @OneToMany(mappedBy = "detective")
    private Set<TrackEntry> trackEntries;
}

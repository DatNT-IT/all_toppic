package com.example.duanlon.model;

import com.example.duanlon.Core.CaseStatus;
import com.example.duanlon.Core.CaseType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class CriminalCase extends AbstractEntity {
    @NotEmpty
    @Column(name = "case_number", unique = true, nullable = false)
    private String number;
    @NotNull
    @Column(name = "case_type")
    @Enumerated(EnumType.STRING)
    private CaseType type;
    @NotEmpty
    @Column(name = "short_description")
    private String shortDescription;
    @NotEmpty
    @Column(name = "detail_description")
    private String detailedDescription;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private String notes;
    @ManyToOne
    @JoinColumn(name = "LEAD_INVESTIGATOR", nullable = false)
    private Detective leadInvestigator;
//    @ManyToMany
//    @JoinTable(
//            name="detective_case",
//            joinColumns=@JoinColumn(name="case_id",
//                    referencedColumnName="id"),
//            inverseJoinColumns=@JoinColumn(name="detective_id",
//                    referencedColumnName="id"))
//    private Set<Evidence> evidenceSet;
    //private Set<Detective> assigned = new HashSet<>();

}

package fis.bank.criminal.model;

import fis.bank.criminal.model.enums.CaseStatus;
import fis.bank.criminal.model.enums.CaseType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_criminal")
public class CriminalCase extends AbstractEntity {
    private String number;

    @Enumerated(EnumType.STRING)
    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Evidence> evidences;

    @ManyToOne
    @JoinColumn(name = "lead_investigator", nullable = false)
    private Detective leadInvestigator; // lead

//    @ManyToMany(mappedBy = "criminalCases")
//    private Set<Detective> assigned;
}

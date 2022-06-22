package fis.bank.criminal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_evidence")
public class Evidence extends AbstractEntity {
    private String number;

    private String itemName;

    private String notes;

    private Boolean archived;

    @ManyToOne
    @JoinColumn(name = "criminal_case_id")
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @OneToMany(mappedBy = "evidence")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TrackEntry> trackEntries;
}

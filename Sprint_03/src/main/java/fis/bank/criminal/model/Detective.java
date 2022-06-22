package fis.bank.criminal.model;

import fis.bank.criminal.model.enums.EmploymentStatus;
import fis.bank.criminal.model.enums.Rank;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_detective")
public class Detective extends AbstractEntity {

    @Column(name = "username", unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String badgeNumber;

    private LocalDateTime hiringDate;

    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    private Boolean armed;

    @Column(name = "status_detective")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "tbl_criminal_detective", joinColumns = @JoinColumn(name = "detective_id")
//            , inverseJoinColumns = @JoinColumn(name = "criminal_case_id"))
//    private Set<CriminalCase> criminalCases;

    @OneToMany(mappedBy = "detective",fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TrackEntry> trackEntries;

}

package fis.bank.criminal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_criminal_detective")
public class CriminalDetective {
    @EmbeddedId
    private CriminalDetectiveKey id;

    @ManyToOne
    @MapsId("criminal_case_id")
    @JoinColumn(name = "criminal_case_id")
    private CriminalCase criminalCase;

    @ManyToOne
    @MapsId("detective_id")
    @JoinColumn(name = "detective_id")
    private Detective detective;
}

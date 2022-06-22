package fis.bank.criminal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CriminalDetectiveKey implements Serializable {
    @Column(name = "criminal_case_id")
    private Long criminal_case_id;

    @Column(name = "detective_id")
    private Long detective_id;
}

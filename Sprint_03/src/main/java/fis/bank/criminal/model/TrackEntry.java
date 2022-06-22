package fis.bank.criminal.model;

import fis.bank.criminal.model.enums.TrackAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_trackEntry")
public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String resson;
}

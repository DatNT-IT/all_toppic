package com.example.duanlon.model;

import com.example.duanlon.core.TrackAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class TrackEntry extends AbstractEntity{
    @NotNull
    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    protected LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    private Evidence evidence;
    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;
    @Enumerated(EnumType.STRING)
    private TrackAction action;
    private String reason;
}

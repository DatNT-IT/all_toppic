package com.example.duanlon.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrackEntry extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;
}

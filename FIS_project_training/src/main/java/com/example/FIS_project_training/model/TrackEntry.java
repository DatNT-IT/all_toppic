package com.example.FIS_project_training.model;

import com.example.bai1.enums.TrackAction;

import java.time.LocalDateTime;

public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String resson;

    public TrackEntry() {
    }

    public TrackEntry(LocalDateTime date, Evidence evidence, Detective detective, TrackAction action, String resson) {
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.resson = resson;
    }

    public TrackEntry(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(id, version, createdAt, modifiedAt);
    }

    public TrackEntry(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime date, Evidence evidence, Detective detective, TrackAction action, String resson) {
        super(id, version, createdAt, modifiedAt);
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.resson = resson;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getResson() {
        return resson;
    }

    public void setResson(String resson) {
        this.resson = resson;
    }

    @Override
    public String toString() {
        return "TrackEntry{" +
                "date=" + date +
                ", evidence=" + evidence +
                ", detective=" + detective +
                ", action=" + action +
                ", resson='" + resson + '\'' +
                '}';
    }
}

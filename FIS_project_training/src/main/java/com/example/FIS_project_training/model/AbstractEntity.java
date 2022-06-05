package com.example.FIS_project_training.model;

import java.time.LocalDateTime;

public class AbstractEntity {
    private long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public AbstractEntity() {
    }

    public AbstractEntity(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}

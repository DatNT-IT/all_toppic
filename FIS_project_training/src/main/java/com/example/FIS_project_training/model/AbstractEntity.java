package com.example.FIS_project_training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;




}

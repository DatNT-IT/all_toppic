package com.example.duanlon.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Data
public class Storage extends AbstractEntity{
    private String name;
    private String location;
    private Set<Evidence> evidenceSet;
}

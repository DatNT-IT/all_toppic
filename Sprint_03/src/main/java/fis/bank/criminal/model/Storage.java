package fis.bank.criminal.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_storage")
public class Storage extends AbstractEntity {
    private String name;
    private String location;

    @OneToMany(mappedBy = "storage")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Evidence> evidences;
}

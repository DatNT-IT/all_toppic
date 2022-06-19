package vn.fis.training.ordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="tbl_customer")
@Data
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotNull
    @NotBlank(message = "Customer's name cannot be null")
    @Size(min = 3, max = 300)
    private String name;

    @Column(name="mobile")
    @Pattern(regexp = "0\\d{9,10}")
    private String mobile;

    @Column(name="address")
    @NotNull
    @NotBlank(message = "Customer's address cannot be null")
    @Size(min = 3, max = 300)
    private String address;

    public Customer(String name, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }
}

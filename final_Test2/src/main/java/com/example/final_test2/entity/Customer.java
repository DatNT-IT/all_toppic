package com.example.final_test2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Customer's name cannot be null")
    @Size(min = 10, max = 100)
    private String name;

    @NotBlank(message = "Customer's mobile cannot be null")
    @Pattern(regexp = "0\\d{9}")
    private String mobile;

    @NotNull
    @NotBlank(message = "Customer's address cannot be null")
    @Size(min = 10, max = 100)
    private String address;

    @OneToMany(mappedBy = "customer")
    @Transient
    private List<Order> orders;
}

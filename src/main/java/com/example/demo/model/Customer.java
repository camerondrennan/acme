package com.example.demo.model;

import com.example.demo.CustomerDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String postcode;
    private LocalDateTime contractEndDate;
    private ContractTier contractTier;

    public Customer(final CustomerDTO customerDTO) {
        this.name = customerDTO.getName();
        this.postcode = customerDTO.getPostcode();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.contractEndDate = LocalDateTime.parse(customerDTO.getContractEndDate(), formatter);
        this.contractTier = customerDTO.getContractTier();
    }
}

package com.example.demo;

import com.example.demo.model.ContractTier;
import lombok.Data;

@Data
public class CustomerDTO {
    private Integer id;
    private String name;
    private String postcode;
    private String contractEndDate;
    private ContractTier contractTier;
}

package com.example.demo.model;


public enum ContractTier {
     Bronze("Bronze"),
    Silver("Silver"),
    Gold("Gold");

    private final String value;

    ContractTier(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}

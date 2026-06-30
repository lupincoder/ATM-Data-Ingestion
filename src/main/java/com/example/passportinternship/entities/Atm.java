package com.example.passportinternship.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("atm")
public class Atm {

    @Id
    @Column("id")
    private String id;

    @Column("dccValue")
    private String dccValue;

    public Atm() {
    }

    public Atm(String id, String dccValue) {
        this.id = id;
        this.dccValue = dccValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDccValue() {
        return dccValue;
    }

    public void setDccValue(String dccValue) {
        this.dccValue = dccValue;
    }
    public void print() {
        System.out.println(id + " " + dccValue);
    }
}

package com.example.passportinternship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Atm {

    @Id
    private Integer id;
    private String dccValue;

    public Atm() {
    }

    public Atm(Integer id, String dccValue) {
        this.id = id;
        this.dccValue = dccValue;
    }
}
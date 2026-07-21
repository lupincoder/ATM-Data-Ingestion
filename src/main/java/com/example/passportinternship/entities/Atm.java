package com.example.passportinternship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Atm {

    @Id
    @GeneratedValue
    private Integer id;

    private String dccValue;
    private String timestamp;
    private String kioskID;
    private String location;

    public Atm() {
    }

    public Atm(String dccValue, String location, String timestamp, String kioskID) {
        this.dccValue = dccValue;
        this.location = location;
        this.timestamp = timestamp;
        this.kioskID = kioskID;
    }
}
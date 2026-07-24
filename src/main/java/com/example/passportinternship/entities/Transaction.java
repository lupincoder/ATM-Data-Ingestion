package com.example.passportinternship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;
    private String acctNum;
    private String status;
    private String transType;
    private Double amount;
    private String location;
    private String timeStamp;

    public Transaction() {
    }

    public Transaction(String acctNum, String timeStamp, String location, Double amount, String transType, String status) {
        this.acctNum = acctNum;
        this.timeStamp = timeStamp;
        this.location = location;
        this.amount = amount;
        this.transType = transType;
        this.status = status;
    }

}

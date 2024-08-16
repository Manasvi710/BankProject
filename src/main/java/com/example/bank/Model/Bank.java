package com.example.bank.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bank")
@Data
public class Bank {
    @Id
    private int accno;
    private String name;
    private double balance;

}

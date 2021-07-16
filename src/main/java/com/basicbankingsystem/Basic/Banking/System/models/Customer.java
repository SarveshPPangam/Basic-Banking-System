package com.basicbankingsystem.Basic.Banking.System.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customers")
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private Timestamp createdAt;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private BankAccount account;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.account = new BankAccount(this);
    }

    public void deposit(double amount){
        this.account.deposit(amount);
    }

    public boolean withdraw(double amount){
        return this.account.withdraw(amount);
    }

}

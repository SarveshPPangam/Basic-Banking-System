package com.basicbankingsystem.Basic.Banking.System.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bank_accounts")
@Getter
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private double balance=0;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BankAccount(Customer customer){
        this.customer = customer;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public void deposit(double amount){
        this.balance += amount;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public boolean withdraw(double amount){
        if(this.balance<amount) return false;
        this.balance -= amount;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        return true;
    }



}

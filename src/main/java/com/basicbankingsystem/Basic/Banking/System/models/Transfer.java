package com.basicbankingsystem.Basic.Banking.System.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transferredFrom;
    private String transferredTo;
    private double amount_transferred;
    private Timestamp transferredAt;

    public Transfer(String transferredFrom, String transferredTo, double amount_transferred) {
        this.transferredFrom = transferredFrom;
        this.transferredTo = transferredTo;
        this.amount_transferred = amount_transferred;
        this.transferredAt = new Timestamp(System.currentTimeMillis());
    }
}

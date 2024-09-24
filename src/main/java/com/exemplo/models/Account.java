package com.exemplo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    private String number;
    private String owner;
    private Double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void makeDeposit(Double amount, LocalDateTime date, String notes) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        this.transactions.add(new Transaction(amount, date, notes));
        this.balance += amount;
    }

    public void makeWithdrawal(Double amount, LocalDateTime date, String notes) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException();
        }
        if (balance - amount < 0) {
            throw new IllegalStateException();
        }
        this.transactions.add(new Transaction(amount, date, notes));
        this.balance -= amount;
    }
}

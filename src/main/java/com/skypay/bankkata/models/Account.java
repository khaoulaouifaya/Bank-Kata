package com.skypay.bankkata.models;

import com.skypay.bankkata.Enums.TypeTransaction;
import com.skypay.bankkata.services.AccountService;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class Account implements AccountService {
    private int balance;
    List<Transaction> transactions=new ArrayList<>();

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        transactions.add(new Transaction(amount, TypeTransaction.DEPOSIT,new Date(),balance));
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;
        transactions.add(new Transaction(amount, TypeTransaction.WITHDRAW,new Date(),balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date              || Amount    || Balance  ");
        System.out.println("--------------------------------------------");
        transactions.stream()
                .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
                .forEach(transaction -> {
                    SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = dateFormat.format(transaction.getDate());
                    String amountTransaction = String.valueOf(transaction.getAmount());
                    if(transaction.getTypeTransaction().equals(TypeTransaction.WITHDRAW)){
                       amountTransaction= "-" + transaction.getAmount();
                    }
                    System.out.printf("%s || %-10s || %-8d%n", formattedDate, amountTransaction, transaction.getBalance());
                });
    }
}

package com.skypay.bankkata.models;

import com.skypay.bankkata.Enums.TypeTransaction;
import com.skypay.bankkata.services.AccountService;
import lombok.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 * A model class representing a bank account, including balance management
 * and transaction tracking.
 */
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class Account implements AccountService {
    private int balance;
    List<Transaction> transactions=new ArrayList<>();

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        transactions.add(new Transaction(amount, TypeTransaction.DEPOSIT,ZonedDateTime.now().minusDays(2),balance));
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;
        transactions.add(new Transaction(amount, TypeTransaction.WITHDRAW, ZonedDateTime.now(),balance));
    }

    /**
     * Prints the account statement in a tabular format.
     */
    @Override
    public void printStatement() {
        System.out.println("Date            || Amount      || Balance");
        System.out.println("-------------------------------------------");
        transactions
                .stream()
                .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
                .forEach(transaction -> {

                    // Format the date in the format dd/MM/yyyy
                    String dateTransaction = transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    // Add a negative sign for withdrawal transactions
                    String amountTransaction = String.valueOf(transaction.getAmount());
                    if (transaction.getTypeTransaction().equals(TypeTransaction.WITHDRAW)) {
                        amountTransaction = "-" + transaction.getAmount();
                    }

                    System.out.printf("%-15s || %-12s || %-10d%n",dateTransaction , amountTransaction, transaction.getBalance());
                });
    }

}

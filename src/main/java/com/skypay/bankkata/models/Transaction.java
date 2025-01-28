package com.skypay.bankkata.models;

import com.skypay.bankkata.Enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;


@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int amount;
    private TypeTransaction typeTransaction;
    private ZonedDateTime date;
    private int balance;
 }

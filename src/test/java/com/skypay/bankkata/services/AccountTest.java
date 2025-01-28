package com.skypay.bankkata.services;

import static org.junit.jupiter.api.Assertions.*;

import com.skypay.bankkata.models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AccountTest {
    @Mock
    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        account = new Account();
    }


    /**
     * Runs test cases to validate the functionality of the Account class.
     */
    @Test
    void testPrintStatement() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        assertEquals(3, account.getTransactions().size());
        assertEquals(2500, account.getBalance());

        account.printStatement();
    }
}

package com.skypay.bankkata.services;

import static org.junit.jupiter.api.Assertions.*;

import com.skypay.bankkata.models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AccountTest {
    @Mock
    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        account = new Account();
    }


    /**
     * This test ensures that the account statement contains the expected transactions.
     * */
    @Test
    void testPrintStatement() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Check that the output matches the expected output.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        account.printStatement();
        System.setOut(originalOut);

        String expectedOutput =
                "Date          || Amount   || Balance" + System.lineSeparator() +
                        "-------------------------------------------" + System.lineSeparator() +
                        "29/01/2025    ||  -500    ||  2500" + System.lineSeparator() +
                        "27/01/2025    ||  1000    ||  1000" + System.lineSeparator() +
                        "27/01/2025    ||  2000    ||  3000" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}

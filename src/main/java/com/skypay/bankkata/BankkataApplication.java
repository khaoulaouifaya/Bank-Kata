package com.skypay.bankkata;

import com.skypay.bankkata.models.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankkataApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankkataApplication.class, args);
		Account account= new Account();
		account.setBalance(5000);
		account.deposit(1500);
		account.withdraw(5000);
		account.printStatement();
	}

}

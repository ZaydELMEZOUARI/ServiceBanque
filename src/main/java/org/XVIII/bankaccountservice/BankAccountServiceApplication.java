package org.XVIII.bankaccountservice;

import org.XVIII.bankaccountservice.entities.BankAccount;
import org.XVIII.bankaccountservice.enums.AccountType;
import org.XVIII.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args ->{
			for (int i = 0; i <10 ; i++) {
				BankAccount bankAccount=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000)
						.createdAt(new Date())
						.currency ("MAD")
						.build();
				bankAccountRepository.save(bankAccount);
			}



		};

	}
}

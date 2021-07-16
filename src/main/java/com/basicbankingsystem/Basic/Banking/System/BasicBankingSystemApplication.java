package com.basicbankingsystem.Basic.Banking.System;

import com.basicbankingsystem.Basic.Banking.System.models.BankAccount;
import com.basicbankingsystem.Basic.Banking.System.models.Customer;
import com.basicbankingsystem.Basic.Banking.System.repositories.CustomerRepository;
import com.basicbankingsystem.Basic.Banking.System.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class BasicBankingSystemApplication {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BasicBankingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}
}

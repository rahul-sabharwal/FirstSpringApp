package com.spring.course.FirstSpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FirstSpringApplication implements CommandLineRunner {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			List<User> users = userRepo.findAll();
			users.forEach(System.out::println);
		}
}

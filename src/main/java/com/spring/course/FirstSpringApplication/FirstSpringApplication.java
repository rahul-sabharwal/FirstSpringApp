package com.spring.course.FirstSpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FirstSpringApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true){
			System.out.println("Enter 1 to Add 2 to show and 3 to exit");
			Scanner scanner  = new Scanner(System.in);
			int n = scanner.nextInt();
			if(n==1){
				System.out.print("Add a new UserName : ");
				String newUser = scanner.next();
				String query = "INSERT INTO users (id, username) Values ('"+generateId()+"', '"+newUser+"');";
				int row = jdbcTemplate.update(query);
				if(row >0){
					System.out.println("New user has been added...");
				}
			} else if(n==2){
				System.out.println("\n\n");
				List<User> users = userRepo.findAll();
				users.forEach(System.out::println);
				System.out.println("\n\n");
			} else if(n==3){
				break;
			} else{
				System.out.println("INVALID INPUT");
			}
		}
	}

	public String generateId(){
		String usedStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvwxyz";
		StringBuilder newStr = new StringBuilder(14);
		for(int i=0;i<14;i++){
			int index = (int) (usedStr.length()*Math.random());
			newStr.append(usedStr.charAt(index));
		}
		return newStr.toString();
	}
}

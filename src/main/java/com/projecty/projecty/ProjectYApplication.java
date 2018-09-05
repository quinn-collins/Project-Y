package com.projecty.projecty;

import com.projecty.projecty.entities.Users;
import com.projecty.projecty.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ProjectYApplication {

	public static void main(String[] args) { SpringApplication.run(ProjectYApplication.class, args); }
}

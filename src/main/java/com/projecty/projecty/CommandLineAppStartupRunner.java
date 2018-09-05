package com.projecty.projecty;

import com.projecty.projecty.entities.Users;
import com.projecty.projecty.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Override
    public void run(String...args) {
        log.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
    }

    @Bean
    public CommandLineRunner demo(UsersRepository usersRepository) {
        return args -> {

            // save some users
            usersRepository.save(new Users("quinnc11", "password", "Quinn", "Collins"));
            usersRepository.save(new Users("npcollins", "password", "Nicholas", "Collins"));
            usersRepository.save(new Users("joe123", "password", "Joe", "Schmoe"));

            // fetch all users
            log.info("Users found with findAll():");
            log.info("---------------------------");
            for(Users users : usersRepository.findAll()) {
                log.info(users.toString());
            }
            log.info("");

            // find user by id
            usersRepository.findById(1L)
                    .ifPresent(users -> {
                        log.info("Users found with findById(1L):");
                        log.info("------------------------------");
                        log.info(users.toString());
                        log.info("");
                    });

            // find user by last name
            log.info("Users found with last name ('Collins'):");
            log.info("------------------------------------------");
            usersRepository.findByLastName("Collins").forEach(collins -> log.info(collins.toString()));
            log.info("");


        };
}}

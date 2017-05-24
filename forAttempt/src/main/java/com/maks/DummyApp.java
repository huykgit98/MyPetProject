package com.maks;

import com.maks.repo.PersonRepo;
import com.maks.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DummyApp implements CommandLineRunner {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    PersonService personService;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DummyApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            personService.testPersonsInput();
            personRepo.findAll().forEach(System.out::println);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
//        personRepo.findAll().forEach(System.out::println);
    }
}

package com.maks.service;

import com.maks.entity.Person;
import com.maks.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepo repo;

    public void testPersonsInput(){
        Person person = new Person("andriy", "petrov");
        Person person2 = new Person("yura", "girkin");
        Person person3 = new Person("yura", "girkin");
        try {
            repo.save(person);
            repo.save(person2);
            repo.save(person3);
        }catch (Exception ex){
            System.err.println(ex.getMessage());

        }
    }

}

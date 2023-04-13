package com.example.store.services;

import com.example.store.models.Person;
import com.example.store.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person findByLogin(Person person){
        Optional<Person> personDB = personRepository.findByLogin(person.getLogin());
        return personDB.orElse(null);
    }
    @Transactional
    public void register(Person person){
            personRepository.save(person);
    }
}

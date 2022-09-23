package com.catalyst.springapp.service;

import com.catalyst.springapp.dao.PersonRepo;
import com.catalyst.springapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonRepo personRepo){
        this.personRepo=personRepo;
    }

    public int addPerson(Person person){
        return personRepo.insertPerson(person);
    }

    public List<Person> getAllPersons(){
        return personRepo.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personRepo.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personRepo.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person){
        return personRepo.updatePersonById(id,person);
    }
}

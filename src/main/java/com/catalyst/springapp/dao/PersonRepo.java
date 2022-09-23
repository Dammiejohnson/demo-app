package com.catalyst.springapp.dao;

import com.catalyst.springapp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepo {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
       UUID id = UUID.randomUUID();
       return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    //why choose to return int
    int updatePersonById(UUID id, Person person);
    //why not return a PersonDto like an update instead of an int

}

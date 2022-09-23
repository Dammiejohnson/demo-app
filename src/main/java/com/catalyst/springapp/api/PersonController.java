package com.catalyst.springapp.api;

import com.catalyst.springapp.model.Person;
import com.catalyst.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPersons();
    }

    @GetMapping(path= "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
        //why not .get since there is no exception class
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable ("id")  UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@Valid @NotNull @RequestBody Person person, @PathVariable("id") UUID id) {
        personService.updatePerson(id, person);
    }
}

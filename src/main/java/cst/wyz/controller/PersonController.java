package cst.wyz.controller;

import cst.wyz.entity.Person;
import cst.wyz.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonController {

    @Autowired
    private PersonService personService;

    public List<Person> list(){
        return personService.list();
    }

    public Person getById(String id){
        return personService.getById(id);
    }

    public String add(Person person){
        personService.add(person);
        return "list";
    }

    public String delete(String id){
        personService.delete(id);
        return "list";
    }

    public String update(Person person){
        personService.update(person);
        return "list";
    }

}

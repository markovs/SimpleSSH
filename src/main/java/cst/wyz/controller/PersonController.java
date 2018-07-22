package cst.wyz.controller;

import cst.wyz.entity.Person;
import cst.wyz.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/list")
    public List<Person> list(){
        return personService.list();
    }

    @RequestMapping("/get")
    public Person getById(@RequestParam(name = "id", required = true) String id){
        return personService.getById(id);
    }

    @RequestMapping("/add")
    public String add(@RequestBody Person person){
        System.out.println(person);
        personService.add(person);
        return "list";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        personService.delete(id);
        return "list";
    }

    @RequestMapping("/update")
    public String update(Person person){
        personService.update(person);
        return "list";
    }

}

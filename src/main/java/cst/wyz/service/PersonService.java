package cst.wyz.service;

import cst.wyz.dao.PersonDao;
import cst.wyz.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void add(Person person) {
        personDao.add(person);
    }

    public List<Person> list() {
        return personDao.list();
    }

    public Person getById(String id) {
        return personDao.getById(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(String id) {
        personDao.delete(id);
    }


}

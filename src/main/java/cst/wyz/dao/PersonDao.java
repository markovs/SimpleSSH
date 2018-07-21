package cst.wyz.dao;

import cst.wyz.entity.Person;

import java.util.List;

public interface PersonDao {

    Person getById(String id);

    List<Person> list();

    void add(Person person);

    void update(Person person);

    void delete(String id);

}

package cst.wyz.dao;

import cst.wyz.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Person getById(String id) {
        return (Person) getSession().get(Person.class,id);
    }

    @Override
    public List<Person> list() {
        return (List<Person>) getSession().createCriteria(Person.class).list();
    }

    @Override
    public void add(Person person) {
        getSession().save(person);
    }

    @Override
    public void update(Person person) {
        getSession().update(person);
    }

    @Override
    public void delete(String id) {
        getSession().delete(getById(id));
    }
}

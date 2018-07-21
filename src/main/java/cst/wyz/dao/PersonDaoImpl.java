package cst.wyz.dao;

import cst.wyz.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;

public class PersonDaoImpl implements PersonDao{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Person getById(String id) {
        return (Person) getSession().get(Person.class.getSimpleName(),id);
    }

    @Override
    public List<Person> list() {
        return null;
    }

    @Override
    public void add(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(String id) {

    }
}

package com.joachimh.pets.dao;

import com.joachimh.pets.db.HibernateUtil;
import com.joachimh.pets.entity.Person;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PersonDaoImpl implements PersonDao{
    @Override
    public void addPerson(Person person) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removePerson(int personId) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Person person = (Person) session.load(Person.class, personId);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePerson(Person person) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Person> getPersonList() {
        List<Person> personList;
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        personList = s.createQuery("from Person").list();
        s.getTransaction().commit();
        s.close();
        return personList;
    }
}

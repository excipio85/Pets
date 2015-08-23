package com.joachimh.pets.service;

import com.joachimh.pets.dao.PersonDao;
import com.joachimh.pets.dao.PersonDaoImpl;
import com.joachimh.pets.entity.Person;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();
    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public void removePerson(int personId) {
        personDao.removePerson(personId);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public List<Person> getPersonList() {
        return personDao.getPersonList();
    }
}

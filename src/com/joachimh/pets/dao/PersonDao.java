package com.joachimh.pets.dao;

import com.joachimh.pets.entity.Person;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public interface PersonDao{

    void addPerson(Person person);
    void removePerson(int personId);
    void updatePerson(Person person);
    List<Person> getPersonList();

}

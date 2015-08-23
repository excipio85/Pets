package com.joachimh.pets.entity;

import com.joachimh.pets.service.PersonServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PersonController {
    private PersonServiceImpl personService = new PersonServiceImpl();
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public void addPerson(Person person){
        personService.addPerson(person);
    }

    public void removePerson(int personId){
        personService.removePerson(personId);
    }

    public void updatePerson(Person person){
        personService.updatePerson(person);
    }

    public ObservableList<Person> getListPerson(){
        if(!personList.isEmpty()){
            personList.clear();
        }
        personList = FXCollections.observableList(personService.getPersonList());
        return personList;
    }
}

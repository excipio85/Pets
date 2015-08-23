package com.joachimh.pets.entity;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Joachim on 20.08.2015.
 */
@Entity
@Table(name="Person", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Email")
})
public class Person implements Serializable{
    private IntegerProperty personId = new SimpleIntegerProperty();
    private StringProperty firstname = new SimpleStringProperty();
    private StringProperty lastname = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<LocalDate>();
    private ObservableList<Pet> pets = FXCollections.observableArrayList();

    public Person(){}

    public Person(int personId, String firstname, String lastname, String email, LocalDate dateOfBirth){
        setPersonId(personId);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PersonID")
    public int getPersonId(){
        return personId.get();
    }

    public void setPersonId(int personId){
        this.personId.set(personId);
    }

    public IntegerProperty personIdProperty(){
        return personId;
    }

    @Column(name="Firstname")
    public String getFirstname(){
        return firstname.get();
    }

    public void setFirstname(String firstname){
        this.firstname.set(firstname);
    }

    public StringProperty firstnameProperty(){
        return firstname;
    }

    @Column(name="Lastname")
    public String getLastname(){
        return lastname.get();
    }

    public void setLastname(String lastname){
        this.lastname.set(lastname);
    }

    public StringProperty lastnameProperty(){
        return lastname;
    }

    @Column(name="Email")
    public String getEmail(){
        return email.get();
    }

    public void setEmail(String email){
        this.email.set(email);
    }

    public StringProperty emailProperty(){
        return email;
    }

    @Column(name="DateOfBirth")
    public LocalDate getDateOfBirth(){
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth.set(dateOfBirth);
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty(){
        return dateOfBirth;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<Pet> getPets(){
        return pets;
    }

    public void setPets(Collection<Pet> pets){
        pets = FXCollections.observableArrayList();
        pets.clear();
        pets.addAll(pets);
    }




}

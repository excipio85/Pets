package com.joachimh.pets.entity;

import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joachim on 20.08.2015.
 */
@Entity
@Table(name = "Pet", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Name")
})
public class Pet implements Serializable{

    private IntegerProperty petId = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<PetType> petType = new SimpleObjectProperty<PetType>();
    private ObjectProperty<Person> owner = new SimpleObjectProperty<Person>();

    public Pet(){}

    public Pet(int petId, String name, PetType petType, Person owner){
        setPetId(petId);
        setName(name);
        setPetType(petType);
        setOwner(owner);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PetID")
    public int getPetId(){
        return petId.get();
    }

    public void setPetId(int petId){
        this.petId.set(petId);
    }

    public IntegerProperty petIdProperty(){
        return petId;
    }

    @Column(name="Name")
    public String getName(){
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);
    }

    public StringProperty nameProperty(){
        return name;
    }

    @Column(name="PetType")
    @Enumerated(EnumType.STRING)
    public PetType getPetType(){
        return petType.get();
    }

    public void setPetType(PetType petType){
        this.petType.set(petType);
    }

    public ObjectProperty<PetType> petTypeProperty(){
        return petType;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PersonID", nullable = false)
    public Person getOwner(){
        return owner.get();
    }

    public void setOwner(Person owner){
        this.owner.set(owner);
    }

    public ObjectProperty<Person> ownerProperty(){
        return owner;
    }

}

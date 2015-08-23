package com.joachimh.pets.dao;

import com.joachimh.pets.entity.Pet;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public interface PetDao {

    void addPet(Pet pet);
    void removePet(int petId);
    void updatePet(Pet pet);
    List<Pet> getPetList();
}

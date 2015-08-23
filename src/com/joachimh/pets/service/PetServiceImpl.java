package com.joachimh.pets.service;

import com.joachimh.pets.dao.PetDao;
import com.joachimh.pets.dao.PetDaoImpl;
import com.joachimh.pets.entity.Pet;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PetServiceImpl implements PetService {
    private PetDao petDao = new PetDaoImpl();

    @Override
    public void addPet(Pet pet) {
        petDao.addPet(pet);
    }

    @Override
    public void removePet(int petId) {
        petDao.removePet(petId);
    }

    @Override
    public void updatePet(Pet pet) {
        petDao.updatePet(pet);
    }

    @Override
    public List<Pet> getPetList() {
        return petDao.getPetList();
    }
}

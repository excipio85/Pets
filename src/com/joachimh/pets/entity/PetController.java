package com.joachimh.pets.entity;

import com.joachimh.pets.service.PetService;
import com.joachimh.pets.service.PetServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PetController {
    private PetService petService = new PetServiceImpl();
    private ObservableList<Pet> petList = FXCollections.observableArrayList();

    public void addPet(Pet pet){
        petService.addPet(pet);
    }

    public void removePet(int petId){
        petService.removePet(petId);
    }

    public void updatePet(Pet pet){
        petService.updatePet(pet);
    }

    public ObservableList<Pet> getPetList(){
       if(!petList.isEmpty()){
           petList.clear();
       }
        petList = FXCollections.observableArrayList(petService.getPetList());
        return petList;
    }
}

package com.joachimh.pets.dao;

import com.joachimh.pets.db.HibernateUtil;
import com.joachimh.pets.entity.Pet;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Joachim on 21.08.2015.
 */
public class PetDaoImpl implements PetDao {
    @Override
    public void addPet(Pet pet) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(pet);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void removePet(int petId) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Pet pet = (Pet) s.load(Pet.class, petId);
        s.delete(pet);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updatePet(Pet pet) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(pet);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Pet> getPetList() {
        List<Pet> petList;
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        petList = s.createQuery("from Pet").list();
        s.getTransaction().commit();
        s.close();
        return petList;
    }
}

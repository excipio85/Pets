package com.joachimh.pets.dao;

import com.joachimh.pets.db.HibernateUtil;
import com.joachimh.pets.entity.Continent;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Joachim on 23.08.2015.
 */
public class ContinentDAOImpl implements ContinentDAO {
    @Override
    public void addContinet(Continent continent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(continent);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void removeContinet(int continentId) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Continent continent = (Continent) s.load(Continent.class, continentId);
        s.delete(continent);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateContinent(Continent continent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(continent);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Continent> getContinentList() {
        List<Continent> continentList;
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        continentList = s.createQuery("from Continent").list();
        s.getTransaction().commit();
        s.close();
        return continentList;
    }
}

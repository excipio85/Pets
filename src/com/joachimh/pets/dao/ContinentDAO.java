package com.joachimh.pets.dao;

import com.joachimh.pets.entity.Continent;

import java.util.List;

/**
 * Created by Joachim on 23.08.2015.
 */
public interface ContinentDAO {

    void addContinet(Continent continent);
    void removeContinet(int continentId);
    void updateContinent(Continent continent);
    List<Continent> getContinentList();

}

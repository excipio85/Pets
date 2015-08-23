package com.joachimh.pets.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joachim on 23.08.2015.
 */
@Entity
@Table(name="CONTINENT")
public class Continent {

    @Id
    @GeneratedValue
    @Column(name="CONT_ID")
    private Integer id;

    @Column(name="CONT_NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONT_ID")
    private Set<Country> countries = new HashSet<Country>();

    // Accessors

    public String getName(){
        return name;
    }

    public Set<Country> getCountries(){
        return countries;
    }

}



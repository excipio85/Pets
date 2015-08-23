package com.joachimh.pets.entity;

import javax.persistence.*;

/**
 * Created by Joachim on 23.08.2015.
 */
@Entity
@Table(name="COUNTRY")
public class Country {

    @Id
    @GeneratedValue
    @Column(name="CTRY_ID")
    private Integer id;

    @Column(name="CTRY_NAME")
    private String name;

    private int area;

    @Transient
    private int rank;

    // Accessors

    public String getName(){
        return name;
    }

}


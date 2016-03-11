package com.jzheadley.RideShareU.models;

import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vehicle [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}

package com.jzheadley.RideShareU.models;

import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "numSeats")
    private int numSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public String toString() {
        return "Vehicle [" +
                "id=" + id +
                ", numSeats=" + numSeats +
                ']';
    }
}

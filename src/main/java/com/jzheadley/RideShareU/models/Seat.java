package com.jzheadley.RideShareU.models;


import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "vehicle")
    private int vehicle;

    @Column(name = "valueFactor")
    private double valueFactor;

    public int getId() {
        return id;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public double getValueFactor() {
        return valueFactor;
    }

    public void setValueFactor(double valueFactor) {
        this.valueFactor = valueFactor;
    }

    @Override
    public String toString() {
        return "Seat [" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", valueFactor=" + valueFactor +
                ']';
    }
}

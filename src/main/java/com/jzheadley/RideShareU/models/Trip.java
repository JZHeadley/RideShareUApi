package com.jzheadley.RideShareU.models;

import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "Trip")
public class Trip {

    /**
     * This is the primary key of the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "vehicle")
    private int vehicleId;

    @Column(name = "driver")
    private int driverId;

    @Column(name = "departureTime")
    private String departureTime;

    @Column(name = "returnTime")
    private String returnTime;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "value")
    private double value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", driverId=" + driverId +
                ", departureTime='" + departureTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", value=" + value +
                '}';
    }
}



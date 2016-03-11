package com.jzheadley.RideShareU.models;

import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "tripseat")
public class TripSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "trip")
    private int tripId;

    @Column(name = "seat")
    private int seatId;

    @Column(name = "user")
    private int userId;

    public int getId() {
        return id;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TripSeat [" +
                "id=" + id +
                ", tripId=" + tripId +
                ", seatId=" + seatId +
                ", userId=" + userId +
                ']';
    }
}

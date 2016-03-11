package com.jzheadley.RideShareU.models;

import javax.persistence.*;

/**
 * Created by zephy on 3/10/2016.
 */
@Entity
@Table(name = "user")
public class User {

    private final int age;
    private final double salary;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public User(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}

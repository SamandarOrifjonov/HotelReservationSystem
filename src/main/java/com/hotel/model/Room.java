package com.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double pricePerNight;

    @Column(nullable = false)
    private boolean available = true;

    public Room() {}

    public Room(int roomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public Long getId() { return id; }
    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

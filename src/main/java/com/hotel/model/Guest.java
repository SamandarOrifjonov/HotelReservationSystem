package com.hotel.model;

import jakarta.persistence.*;

@Embeddable
public class Guest {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    public Guest() {}

    public Guest(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
}

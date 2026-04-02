package com.hotel.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReservationRequest {

    @NotNull(message = "Room number is required")
    private Integer roomNumber;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Min(value = 1, message = "Nights must be at least 1")
    private int nights;

    public Integer getRoomNumber() { return roomNumber; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getNights() { return nights; }
}

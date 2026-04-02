package com.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @JsonIgnoreProperties("reservations")
    private Room room;

    @Column(nullable = false)
    private int nights;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate reservationDate = LocalDate.now();

    public Reservation() {}

    public Reservation(Guest guest, Room room, int nights) {
        this.guest = guest;
        this.room = room;
        this.nights = nights;
    }

    public Long getId() { return id; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public int getNights() { return nights; }
    public LocalDate getReservationDate() { return reservationDate; }

    public double calculateTotalPrice() {
        return room.getPricePerNight() * nights;
    }
}

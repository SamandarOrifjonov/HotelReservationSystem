package com.hotel.controller;

import com.hotel.dto.ReservationRequest;
import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // GET /api/reservations
    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    // GET /api/reservations/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    // POST /api/reservations
    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody ReservationRequest request) {
        return ResponseEntity.status(201).body(reservationService.create(request));
    }

    // DELETE /api/reservations/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        reservationService.cancel(id);
        return ResponseEntity.noContent().build();
    }
}

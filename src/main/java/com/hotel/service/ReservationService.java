package com.hotel.service;

import com.hotel.dto.ReservationRequest;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.exception.RoomNotAvailableException;
import com.hotel.model.Guest;
import com.hotel.model.Reservation;
import com.hotel.model.Room;
import com.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found: " + id));
    }

    @Transactional
    public Reservation create(ReservationRequest request) {
        Room room = roomService.getRoomByNumber(request.getRoomNumber());

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room " + request.getRoomNumber() + " is not available");
        }

        room.setAvailable(false);
        roomService.save(room);

        Reservation reservation = new Reservation(
                new Guest(request.getFullName(), request.getPhoneNumber()),
                room,
                request.getNights()
        );
        return reservationRepository.save(reservation);
    }

    @Transactional
    public void cancel(Long id) {
        Reservation reservation = getById(id);
        reservation.getRoom().setAvailable(true);
        roomService.save(reservation.getRoom());
        reservationRepository.deleteById(id);
    }
}

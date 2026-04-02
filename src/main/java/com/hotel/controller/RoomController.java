package com.hotel.controller;

import com.hotel.model.Room;
import com.hotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // GET /api/rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // GET /api/rooms/available
    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    // GET /api/rooms/{roomNumber}
    @GetMapping("/{roomNumber}")
    public ResponseEntity<Room> getRoom(@PathVariable int roomNumber) {
        return ResponseEntity.ok(roomService.getRoomByNumber(roomNumber));
    }

    // POST /api/rooms
    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return ResponseEntity.status(201).body(roomService.save(room));
    }
}

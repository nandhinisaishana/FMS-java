package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.RoomRequestDTO;
import com.vinsup.fms.dto.RoomResponseDTO;
import com.vinsup.fms.model.Floor;
import com.vinsup.fms.model.Room;
import com.vinsup.fms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	/*
	 * {
  "roomNumber": "101",
  "description": "Consultation Room",
  "floorNumber": 1
}

	 */
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<RoomResponseDTO> createRoom(@RequestBody RoomRequestDTO request) {
    	Optional<Floor> floorOpt = roomService.getFloorByNumber(request.getFloorNumber());

        //Optional<Floor> floorOpt = roomService.getFloorByName(request.getFloorNumber());
        if (!floorOpt.isPresent()) {
            return new ResponseEntity<>(new RoomResponseDTO("Floor not found"), HttpStatus.BAD_REQUEST);
        }

        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());
        room.setDescription(request.getDescription());
        room.setFloor(floorOpt.get());
        room.setCreatedBy("Admin");
        roomService.saveRoom(room);

        return new ResponseEntity<>(new RoomResponseDTO("Room created successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.getRoomById(id);
        return room.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}

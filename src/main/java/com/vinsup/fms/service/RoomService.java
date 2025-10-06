/*package com.vinsup.fms.service;

import com.vinsup.fms.model.Room;
import com.vinsup.fms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}*/

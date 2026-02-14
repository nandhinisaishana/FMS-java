package com.vinsup.fms.service;

import com.vinsup.fms.model.Block;
import com.vinsup.fms.model.Floor;
import com.vinsup.fms.repository.BlockRepository;
import com.vinsup.fms.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {

    private final FloorRepository floorRepository;
    private final BlockRepository blockRepository;

    @Autowired
    public FloorService(FloorRepository floorRepository, BlockRepository blockRepository) {
        this.floorRepository = floorRepository;
        this.blockRepository = blockRepository;
    }

    public Floor saveFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    public Optional<Floor> getFloorById(Long id) {
        return floorRepository.findById(id);
    }

    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }

    public void deleteFloor(Long id) {
        floorRepository.deleteById(id);
    }

    public Optional<Block> getBlockByName(String name) {
        return blockRepository.findByName(name);
    }
}


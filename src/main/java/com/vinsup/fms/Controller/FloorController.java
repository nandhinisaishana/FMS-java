package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.FloorRequestDTO;
import com.vinsup.fms.dto.FloorResponseDTO;
import com.vinsup.fms.model.Block;
import com.vinsup.fms.model.Floor;
import com.vinsup.fms.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/floors")
public class FloorController {
	/*
	 * {
  "floorNumber": 1,
  "description": "Ground floor for reception",
  "blockName": "Block A"
}

	 */
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping
    public ResponseEntity<FloorResponseDTO> createFloor(@RequestBody FloorRequestDTO request) {
        Optional<Block> blockOpt = floorService.getBlockByName(request.getBlockName());
        if (!blockOpt.isPresent()) {
            return new ResponseEntity<>(new FloorResponseDTO("Block not found"), HttpStatus.BAD_REQUEST);
        }

        Floor floor = new Floor();
        floor.setFloorNumber(request.getFloorNumber());
        floor.setDescription(request.getDescription());
        floor.setBlock(blockOpt.get());
        floor.setCreatedBy("Admin");
        floorService.saveFloor(floor);

        return new ResponseEntity<>(new FloorResponseDTO("Floor created successfully"), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Floor>> getAllFloors() {
        return ResponseEntity.ok(floorService.getAllFloors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloorById(@PathVariable Long id) {
        Optional<Floor> floor = floorService.getFloorById(id);
        return floor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable Long id) {
        floorService.deleteFloor(id);
        return ResponseEntity.noContent().build();
    }
}

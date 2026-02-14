package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.dto.BuildingRequestDTO;
import com.vinsup.fms.dto.BuildingResponseDTO;
import com.vinsup.fms.model.Building;
import com.vinsup.fms.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BuildingController {
	/*
	 * {
  "name": "Main Building",
  "description": "Corporate Headquarters"
}

	 */
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }


    @PostMapping("/create-building")
    public ResponseEntity<?> createBuilding(@RequestBody BuildingRequestDTO dto) {
        Building building = new Building();
        building.setName(dto.getName());
        building.setDescription(dto.getDescription());
        building.setCreatedBy("Admin"); 
        buildingService.saveBuilding(building);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse("Building created successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBuilding(@PathVariable Long id) {
        Optional<Building> building = buildingService.getBuildingById(id);
        if (building.isPresent()) {
            Building b = building.get();
            BuildingResponseDTO response = new BuildingResponseDTO(
                    b.getId(), b.getName(), b.getDescription(), b.getCreatedBy(), b.getCreatedAt()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("Building not found"));
        }
    }

    
    @GetMapping("/buildings")
    public ResponseEntity<?> getAllBuildings() {
        List<Building> buildings = buildingService.getAllBuildings();
        if (buildings.isEmpty()) {
            return ResponseEntity.ok(new MessageResponse("No buildings found"));
        }

        List<BuildingResponseDTO> responses = buildings.stream()
                .map(b -> new BuildingResponseDTO(
                        b.getId(), b.getName(), b.getDescription(), b.getCreatedBy(), b.getCreatedAt()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateBuilding(@PathVariable Long id, @RequestBody BuildingRequestDTO dto) {
        return buildingService.getBuildingById(id)
                .map(building -> {
                    building.setName(dto.getName());
                    building.setDescription(dto.getDescription());
                    building.setUpdatedAt(java.time.LocalDateTime.now());

                    buildingService.saveBuilding(building);
                    return ResponseEntity.ok(new MessageResponse("Building updated successfully"));
                })
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(new MessageResponse("Building not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.ok(new MessageResponse("Building deleted successfully"));
    }

    static class MessageResponse {
        private String message;
        public MessageResponse(String message) { this.message = message; }
        public String getMessage() { return message; }
    }
}

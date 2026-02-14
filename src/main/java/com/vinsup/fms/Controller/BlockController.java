


package com.vinsup.fms.Controller;

import com.vinsup.fms.dto.BlockRequestDTO;
import com.vinsup.fms.dto.BlockResponseDTO;
import com.vinsup.fms.model.Block;
import com.vinsup.fms.model.Building;
import com.vinsup.fms.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blocks")
public class BlockController {
	/*
	 * {
  "name": "Block A",
  "description": "This is the first block",
  "buildingName": "Main Hospital Building"
}

	 */
    private final BlockService blockService;

    @Autowired
    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    
    
    @PostMapping
    public ResponseEntity<BlockResponseDTO> createBlock(@RequestBody BlockRequestDTO request) {
        Optional<Building> buildingOpt = blockService.getBuildingByName(request.getBuildingName());
        if (!buildingOpt.isPresent()) {
            return new ResponseEntity<>(new BlockResponseDTO("Building not found"), HttpStatus.BAD_REQUEST);
        }

        Block block = new Block();
        block.setName(request.getName());
        block.setDescription(request.getDescription()); 
        block.setBuilding(buildingOpt.get());
        block.setCreatedBy("Admin"); // storing string
        blockService.saveBlock(block);
               

        return new ResponseEntity<>(new BlockResponseDTO("Block created successfully"), HttpStatus.CREATED);
    }

    
   


    // GET all
    @GetMapping
    public ResponseEntity<List<Block>> getAllBlocks() {
        return ResponseEntity.ok(blockService.getAllBlocks());
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Block> getBlockById(@PathVariable Long id) {
        Optional<Block> block = blockService.getBlockById(id);
        return block.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
        return ResponseEntity.noContent().build();
    }
}

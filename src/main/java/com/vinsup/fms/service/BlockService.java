package com.vinsup.fms.service;

import com.vinsup.fms.model.Block;
import com.vinsup.fms.model.Building;
import com.vinsup.fms.repository.BlockRepository;
import com.vinsup.fms.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService {

    private final BlockRepository blockRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public BlockService(BlockRepository blockRepository, BuildingRepository buildingRepository) {
        this.blockRepository = blockRepository;
        this.buildingRepository = buildingRepository;
    }

    public Block saveBlock(Block block) {
        return blockRepository.save(block);
    }

    public Optional<Block> getBlockById(Long id) {
        return blockRepository.findById(id);
    }

    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    public void deleteBlock(Long id) {
        blockRepository.deleteById(id);
    }

    //public Optional<Building> getBuildingById(Long id) {//this one
    //   return buildingRepository.findById(id);
    //}
    
    public Optional<Building> getBuildingByName(String buildingName) {
        return buildingRepository.findByName(buildingName);
    }

  

}




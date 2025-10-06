/*package com.vinsup.fms.service;

import com.vinsup.fms.model.Block;
import com.vinsup.fms.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService {

    private final BlockRepository blockRepository;

    @Autowired
    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
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
}*/

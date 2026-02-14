
package com.vinsup.fms.service;

import com.vinsup.fms.model.Building;
import com.vinsup.fms.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }
    
//create
    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    //getmapping byid
    public Optional<Building> getBuildingById(Long id) {
        return buildingRepository.findById(id);
    }

    //getall
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    //delete
    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }

    public long countBuildings() {
        return buildingRepository.count();
    }
}

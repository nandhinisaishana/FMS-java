/*this one
package com.vinsup.fms.service;


import com.vinsup.fms.repository.UserRepository;
import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final BuildingRepository buildingRepository;

    public AdminService(UserRepository userRepository,
                        BuildingRepository buildingRepository) {
        this.userRepository = userRepository;
        this.buildingRepository = buildingRepository;
    }

    public ApiResponse getDashboard() {
        long userCount = userRepository.count();
        long buildingCount = buildingRepository.count();

        String data = String.format("Total Users: %d, Total Buildings: %d", userCount, buildingCount);
        return new ApiResponse("Admin Dashboard", data);
    }

}*/



package com.vinsup.fms.service;

import com.vinsup.fms.dto.ApiResponse;
import com.vinsup.fms.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {

    private final UserRepository userRepository;
    

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;   
    }

    public ApiResponse getDashboard() {
        long userCount = userRepository.count();
       
                                                                                                                              
        Map<String, Object> data = new HashMap<>();
        data.put("totalUsers", userCount);
       

        return new ApiResponse("Admin Dashboard", data);
    }
}


/*package com.vinsup.fms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.vinsup.fms.model.Role;
import com.vinsup.fms.model.User;
import com.vinsup.fms.repository.RoleRepository;
import com.vinsup.fms.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository,
                           PasswordEncoder passwordEncoder){
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(){ { setName("ROLE_ADMIN"); } }));

        if(userRepository.findByEmail("admin@fms.com").isEmpty()){
            User admin = new User();
            admin.setFullName("Admin");
            admin.setEmail("admin@fms.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(adminRole);
            userRepository.save(admin);
        }
    }
}
*/
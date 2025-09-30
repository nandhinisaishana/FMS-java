package com.vinsup.fms;

	import java.util.List;
																																																																																								
import org.springframework.stereotype.Service;

@Service
public class UserService {

	    private final UserRepository userRepo;
	    private final RoleRepository roleRepo;

	    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
	        this.userRepo = userRepo;
	        this.roleRepo = roleRepo;
	    }

	    public User signup(String username, String password, String roleName) {
	        Role role = roleRepo.findByName(roleName)
	                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));

	        String hashed = PasswordUtil.hashPassword(password);
	        User user = new User(username, hashed, role);
	        return userRepo.save(user);
	    }

	    public boolean login(String username, String password, String roleName) {
	        User user = userRepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!user.getRole().getName().equalsIgnoreCase(roleName)) {
	            throw new RuntimeException("Role mismatch for this user");
	        }
	        return PasswordUtil.checkPassword(password, user.getPassword());
	    }

	    public List<User> getAllUsers() {
	        return userRepo.findAll();
	    }
	}


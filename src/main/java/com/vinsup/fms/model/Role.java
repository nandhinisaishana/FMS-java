package com.vinsup.fms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; 

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    
    public Long getIdFromName (String role) {
    	return id;
    }
}

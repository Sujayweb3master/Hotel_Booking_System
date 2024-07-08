package com.main.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Hotel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String address;
	private String contactInfo;
    private String description;
    private String amenities;
    
    @ElementCollection
    private Set<String> images;
 
    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonBackReference
    private User manager;
    
    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms;
}

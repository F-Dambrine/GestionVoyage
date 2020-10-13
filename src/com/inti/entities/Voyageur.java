package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Voyageur implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyageur;
	private String nom;
	private String prenom;
	private int age;
	
	@OneToMany(mappedBy="voyageur")
	private Set<Reservation> reservations= new HashSet<>();
	
	public Voyageur() {
	}
	
	public Long getIdVoyageur() {
		return idVoyageur;
	}
	public void setIdVoyageur(Long idVoyageur) {
		this.idVoyageur = idVoyageur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

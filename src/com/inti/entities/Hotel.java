package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String nom;
	private int nbEtoile;
	
	@ManyToOne
	private Destination destination;
	
	@OneToMany(mappedBy="reservation")
	private Set<Reservation> reservations= new HashSet<>();
	
	@OneToMany(mappedBy="avis")
	private Set<Avis> avisSet= new HashSet<>();
	
	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nom=" + nom + ", nbEtoile=" + nbEtoile + "]";
	}
	public Hotel() {
		super();
	}
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbEtoile() {
		return nbEtoile;
	}
	public void setNbEtoile(int nbEtoile) {
		this.nbEtoile = nbEtoile;
	}
	
	
}

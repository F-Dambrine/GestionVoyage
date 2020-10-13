package com.inti.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Reservation;
import com.inti.entities.Voyageur;
import com.inti.service.impl.ManagerService;
import com.inti.service.interfaces.IService;

@ManagedBean
@SessionScoped
public class VoyageurManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Voyageur voyageur;
	private List<Voyageur> voyageurs = new ArrayList<Voyageur>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	IService<Voyageur> voyageurService = new ManagerService<Voyageur>();
	IService<Reservation> reservationService = new ManagerService<Reservation>();
	
	public VoyageurManagedBean() {
	}

	public Voyageur getVoyageur() {
		return voyageur;
	}

	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@PostConstruct
	public void init() {
		this.voyageurs = voyageurService.findAll(Voyageur.class);
	}
	public void refresh() {
		init();
	}
	public void addVoyageur() {
		try {
			voyageurService.save(this.voyageur);
			this.voyageur = new Voyageur();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String updateVoyageur() {
		try {
			voyageurService.update(this.voyageur);
			this.voyageur = new Voyageur();
			return "hotel?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "editVoyageur";
		}
	}
	public String editVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
		return "editVoyageur";
	}
	public void deleteVoyageur(Voyageur voyageur) {
		try {
			voyageurService.remove(voyageur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.inti.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Hotel;
import com.inti.entities.Reservation;
import com.inti.entities.Voyageur;
import com.inti.service.impl.ManagerService;
import com.inti.service.interfaces.IService;

@ManagedBean
@SessionScoped
public class ReservationManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Reservation reservation;
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private List<Voyageur> voyageurs = new ArrayList<Voyageur>();
	IService<Reservation> reservationService = new ManagerService<Reservation>();
	IService<Hotel> hotelService = new ManagerService<Hotel>();
	IService<Voyageur> voyageurService = new ManagerService<Voyageur>();
	
	public ReservationManagedBean() {
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(List<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}

	@PostConstruct
	public void init() {
		this.reservations = reservationService.findAll(Reservation.class);
	}
	public void refresh() {
		init();
	}
	public void addReservation() {
		try {
			reservationService.save(this.reservation);
			this.reservation = new Reservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String updateReservation() {
		try {
			reservationService.update(this.reservation);
			this.reservation = new Reservation();
			return "hotel?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "editReservation";
		}
	}
	public String editReservation(Reservation reservation) {
		this.reservation = reservation;
		return "editReservation";
	}
	public void deleteReservation(Reservation reservation) {
		try {
			reservationService.remove(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

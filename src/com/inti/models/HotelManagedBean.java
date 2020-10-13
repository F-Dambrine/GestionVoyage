package com.inti.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.inti.entities.Avis;
import com.inti.entities.Hotel;
import com.inti.entities.Reservation;
import com.inti.service.impl.HotelService;
import com.inti.service.impl.ManagerService;
import com.inti.service.interfaces.IHotelService;

@ManagedBean
@SessionScoped
public class HotelManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Hotel hotel = new Hotel();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	IHotelService hotelService = new HotelService();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Avis> avisList = new ArrayList<Avis>();
	ManagerService managerService = new ManagerService();
	
	
	
	public HotelManagedBean() {
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Hotel> getHotels() {
		hotels = hotelService.findAll(Hotel.class);
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	@PostConstruct
	private void init() {
		this.hotels = hotelService.findAll(Hotel.class);
	}
	
	public void refresh() {
		init();
	}
	public List<Reservation> getReservations() {
		reservations = managerService.findAll(Reservation.class);
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<Avis> getAvisList() {
		avisList = managerService.findAll(Avis.class);
		return avisList;
	}
	public void setAvisList(List<Avis> avisList) {
		avisList = avisList;
	}
	public void enregistrerHotel() {
		try {
			hotelService.save(this.hotel);
			this.hotel = new Hotel(); // Permet de remettre le form vide
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void supprimerHotel(Hotel hotel) {
		try {
			hotelService.remove(hotel);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

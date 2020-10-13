package com.inti.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Destination;
import com.inti.entities.Hotel;
import com.inti.service.impl.ManagerService;
import com.inti.service.interfaces.IService;

@ManagedBean
@SessionScoped
public class DestinationManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Destination destination;
	private List<Destination> destinations = new ArrayList<Destination>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	IService<Destination> destinationService = new ManagerService<Destination>();
	IService<Hotel> hotelService = new ManagerService<Hotel>();
	
	public DestinationManagedBean() {
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@PostConstruct
	private void init() {
		this.destinations=destinationService.findAll(Destination.class);
	}
	public void refresh() {
		init();
	}
	public void addDestination() {
		try {
			destinationService.save(this.destination);
			this.destination = new Destination();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String updateDestination() {
		try {
			destinationService.update(this.destination);
			this.destination = new Destination();
			return "accueil?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "editDestination";
		}
	}
	public String editDestination(Destination destination) {
		this.destination = destination;
		return "edit";
	}
	public void deleteDestination(Destination destination) {
		try {
			destinationService.remove(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

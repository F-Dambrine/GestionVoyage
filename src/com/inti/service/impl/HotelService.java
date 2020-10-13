package com.inti.service.impl;

import com.inti.DAO.impl.HotelDAO;
import com.inti.DAO.interfaces.IHotelDAO;
import com.inti.entities.Hotel;
import com.inti.service.interfaces.IHotelService;

public class HotelService extends ManagerService<Hotel> implements IHotelService {
	private IHotelDAO hotelDAO = new HotelDAO();

	@Override
	public Hotel findHotelWithName(String name) {
		return hotelDAO.findHotelWithName(name);
	}
}
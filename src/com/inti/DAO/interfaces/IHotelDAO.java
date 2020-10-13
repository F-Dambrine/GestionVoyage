package com.inti.DAO.interfaces;

import com.inti.entities.Hotel;

public interface IHotelDAO {
	Hotel findHotelWithName(String name);
}

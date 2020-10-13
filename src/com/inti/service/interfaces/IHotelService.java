package com.inti.service.interfaces;

import com.inti.entities.Hotel;

public interface IHotelService extends IService<Hotel>{
	Hotel findHotelWithName(String name);
}

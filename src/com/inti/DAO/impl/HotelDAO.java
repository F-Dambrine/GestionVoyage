package com.inti.DAO.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.inti.DAO.interfaces.IHotelDAO;
import com.inti.entities.Hotel;
import com.inti.util.HibernateUtility;

public class HotelDAO extends ManagerDAO<Hotel> implements IHotelDAO {

	@Override
	public Hotel findHotelWithName(String name) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Criteria crit = s.createCriteria(Hotel.class);
		crit.add(Restrictions.eq("name", name));
		return (Hotel) crit.uniqueResult();
	}
}

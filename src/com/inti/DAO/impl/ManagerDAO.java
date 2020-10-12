package com.inti.DAO.impl;


import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.DAO.interfaces.IDAO;
import com.inti.util.HibernateUtility;



public class ManagerDAO<T> implements IDAO<T> {
	Session s = HibernateUtility.getSessionFactory().openSession();

	@Override
	public void save(T obj) {
		try {
			s.getTransaction().begin();
			s.persist(obj);
			s.getTransaction().commit();
			// s.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(T obj) {
		try {
			s.getTransaction().begin();
			s.merge(obj);
			s.getTransaction().commit();
			// s.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remove(T obj) {
		try {
			s.getTransaction().begin();
			s.delete(obj);
			s.getTransaction().commit();
			s.flush();
			// s.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<T> findAll(Class<?> c) {
		try {
			s.getTransaction().begin();
			Query queryHql = s.createQuery(" from " + c.getName());
			List<T> liste = queryHql.list();
			s.getTransaction().commit();
			// s.close();
			return liste;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T findOne(Class<?> c, Long id) {
		T t;
		s.getTransaction().begin();
		t = (T) s.get(c, id);
		return t;
	}

}

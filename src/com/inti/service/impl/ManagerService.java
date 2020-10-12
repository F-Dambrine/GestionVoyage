package com.inti.service.impl;

import java.util.List;

import com.inti.DAO.impl.ManagerDAO;
import com.inti.DAO.interfaces.IDAO;
import com.inti.service.interfaces.IService;



public class ManagerService<T> implements IService<T> {
	IDAO<T> dao = new ManagerDAO<T>();

	@Override
	public void save(T obj) {
		dao.save(obj);

	}

	@Override
	public void update(T obj) {
		dao.update(obj);

	}

	@Override
	public void remove(T obj) {
		dao.remove(obj);

	}

	@Override
	public List<T> findAll(Class<?> c) {
		return dao.findAll(c);
	}

	@Override
	public T findOne(Class<?> c, Long id) {
		return dao.findOne(c, id);
	}

}

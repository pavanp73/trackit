package org.project.trackit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.project.trackit.dao.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public abstract class GenericServiceImpl<T> implements IGenericService<T>{

	@Autowired
	private IGenericDao<T> genericDao;
	
	@Override
	public void save(T entity) {
		
		genericDao.save(entity);
	}
	
	@Override
	public List<T> getList() {
		
		return genericDao.getList();
	}
	
	@Override
	public T findById(Object id) {
		
		return genericDao.findById(id);
	}
	
}

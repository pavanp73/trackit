package org.project.trackit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.project.trackit.dao.IGenericDao;
import org.project.trackit.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public abstract class GenericServiceImpl<T> implements IGenericService<T>{

	@Autowired
	private IGenericDao<T> genericDao;
	
	@Override
	public void saveEntity(T entity) {
		
		genericDao.saveEntity(entity);
	}
	
	@Override
	public List<T> getEntityList() {
		
		return genericDao.getEntityList();
	}
	
	@Override
	public T findEntityById(Object id) {
		
		return genericDao.findEntityById(id);
	}
	
}

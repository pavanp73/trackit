package org.project.trackit.dao;

import java.util.List;

public interface IGenericDao<T>{

	void saveEntity(T entity);
	
	List<T> getEntityList();
	
	T findEntityById(Object id);
}

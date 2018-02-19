package org.project.trackit.dao;

import java.util.List;

public interface IGenericDao<T>{

	void save(T entity);
	
	List<T> getList();
	
	T findById(Object id);
}

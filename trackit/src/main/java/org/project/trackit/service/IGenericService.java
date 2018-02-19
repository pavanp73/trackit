package org.project.trackit.service;

import java.util.List;

public interface IGenericService<T> {

	void save(T entity);

	List<T> getList();

	T findById(Object id);

}

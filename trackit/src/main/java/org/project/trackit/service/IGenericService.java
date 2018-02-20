package org.project.trackit.service;

import java.util.List;

public interface IGenericService<T> {

	void saveEntity(T entity);

	List<T> getEntityList();

	T findEntityById(Object id);

}

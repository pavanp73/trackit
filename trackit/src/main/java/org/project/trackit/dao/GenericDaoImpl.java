package org.project.trackit.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T> implements IGenericDao<T>{

	@PersistenceContext
	protected EntityManager entityManager;
	
	protected String tableName;
	private Class<? extends T> daoType;
	
	public GenericDaoImpl() {
		
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		daoType = (Class<? extends T>) pt.getActualTypeArguments()[0];
	}
	
	public GenericDaoImpl(String tableName) {
		this();
		this.tableName = tableName;
	}
	
	@Override
	public void saveEntity(T entity) {
		
		entityManager.persist(entity);
	}
	
	@Override
	public List<T> getEntityList() {
		
		String sql = "from "+tableName.toUpperCase();
		return entityManager.createQuery(sql).getResultList();
	}
	
	@Override
	public T findEntityById(Object id) {
		
		return entityManager.find(daoType, id);
	}
	
}

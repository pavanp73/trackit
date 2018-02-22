package org.project.trackit.dao;

import javax.transaction.Transactional;

import org.project.trackit.model.CourseCatalog;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class CourseCatalogDaoImpl extends GenericDaoImpl<CourseCatalog> implements ICourseCatalogDao{

	public CourseCatalogDaoImpl() {
		super("COURSE_CATALOG");
	}
	
}

package org.project.trackit.service;

import javax.transaction.Transactional;

import org.project.trackit.model.CourseCatalog;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class CourseCatalogServiceImpl extends GenericServiceImpl<CourseCatalog> implements ICourseCatalogService{

}

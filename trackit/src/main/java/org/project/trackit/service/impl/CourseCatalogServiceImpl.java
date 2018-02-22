package org.project.trackit.serviceimpl;

import javax.transaction.Transactional;

import org.project.trackit.model.CourseCatalog;
import org.project.trackit.service.ICourseCatalogService;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class CourseCatalogServiceImpl extends GenericServiceImpl<CourseCatalog> implements ICourseCatalogService{

}

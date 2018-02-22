package org.project.trackit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.project.trackit.model.CourseCatalog;
import org.project.trackit.model.Profile;
import org.project.trackit.model.ProfileCourses;
import org.project.trackit.service.ICourseCatalogService;
import org.project.trackit.service.IProfileServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ProfileCoursesDaoImpl extends GenericDaoImpl<ProfileCourses> implements IProfileCoursesDao{

	@Autowired
	private IProfileServie profileService;
	
	@Autowired
	private ICourseCatalogService courseCatalogService;
	
	public ProfileCoursesDaoImpl() {
		super("PROFILE_COURSES");
	}

	@Override
	public List<ProfileCourses> getCoursesByProfileId(long profileId) {
		
		Profile profile = profileService.findEntityById(profileId);
		
		String sql = "from "+tableName+" PC where PC.profile=:profile";
		
		return entityManager.createQuery(sql, ProfileCourses.class)
				.setParameter("profile", profile)
				.getResultList();
	}

	@Override
	public void saveCourseForProfile(ProfileCourses course, long profileId) {
		
		Profile profile = profileService.findEntityById(profileId);
		course.setProfile(profile);
		CourseCatalog courseCatalog = courseCatalogService.findEntityById(course.getCourseBasicInfo().getCourseId());
		course.setCourseBasicInfo(courseCatalog);
		saveEntity(course);	
	}
	
}

package org.project.trackit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.project.trackit.dao.IProfileCoursesDao;
import org.project.trackit.model.ProfileCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProfileCoursesServiceImpl extends GenericServiceImpl<ProfileCourses> implements IProfileCoursesService{

	@Autowired
	private IProfileCoursesDao profileCoursesDao;
	
	@Override
	public List<ProfileCourses> getCoursesByProfileId(long profileId) {
		
		return profileCoursesDao.getCoursesByProfileId(profileId);
	}

	@Override
	public void saveCourseForProfile(ProfileCourses course, long profileId) {
		
		profileCoursesDao.saveCourseForProfile(course, profileId);
		
	}
	
}

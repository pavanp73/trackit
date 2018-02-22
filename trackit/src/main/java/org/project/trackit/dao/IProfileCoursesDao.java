package org.project.trackit.dao;

import java.util.List;

import org.project.trackit.model.ProfileCourses;

public interface IProfileCoursesDao extends IGenericDao<ProfileCourses>{

	void saveCourseForProfile(ProfileCourses course, long profileId);
	
	List<ProfileCourses> getCoursesByProfileId(long profileId);
	
}

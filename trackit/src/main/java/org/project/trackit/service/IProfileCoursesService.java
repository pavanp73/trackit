package org.project.trackit.service;

import java.util.List;

import org.project.trackit.model.ProfileCourses;

public interface IProfileCoursesService extends IGenericService<ProfileCourses>{

	void saveCourseForProfile(ProfileCourses course, long profileId);
	
	List<ProfileCourses> getCoursesByProfileId(long profileId);
	
}

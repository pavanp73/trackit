package org.project.trackit.controller;

import java.util.List;

import org.project.trackit.model.ProfileCourses;
import org.project.trackit.service.IProfileCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileCoursesController {

	@Autowired
	private IProfileCoursesService profileCoursesService;
	
	@PostMapping("/{profileId}/courses")
	public String addCourse(@RequestBody ProfileCourses course, @PathVariable("profileId") long profileId) {
		
		profileCoursesService.saveCourseForProfile(course, profileId);
		
		return "Course "+course.getCourseBasicInfo().getCourseName()+" has been added to the list";
		
	}
	
	@GetMapping("/{profileId}/courses")
	public List<ProfileCourses> getProfileCourseList(@PathVariable("profileId") long profileId){
		
		return profileCoursesService.getCoursesByProfileId(profileId);
	}
}

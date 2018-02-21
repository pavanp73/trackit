package org.project.trackit.controller;

import java.util.List;

import org.project.trackit.model.CourseCatalog;
import org.project.trackit.service.ICourseCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseCatalogController {
	
	@Autowired
	private ICourseCatalogService courseCatalogService;
	
	@PostMapping
	public String saveCourse(@RequestBody CourseCatalog course){
		
		courseCatalogService.saveEntity(course);
		return "Course has been added with id "+ course.getCourseId();
	}
	
	@GetMapping
	public List<CourseCatalog> getCourseList(){

		return courseCatalogService.getEntityList();
	}
}

package org.project.trackit.controller;

import java.util.List;

import org.project.trackit.model.Profile;
import org.project.trackit.service.IProfileServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	private IProfileServie profileService;
	
	@PostMapping
	public String save(@RequestBody Profile profile){
		
		profileService.saveProfileWithRole(profile);
		return "User has been added with id "+ profile.getProfileId();
	}
	
	@GetMapping
	public List<Profile> getProfileList(){

		return profileService.getEntityList();
	}
	
	@GetMapping("/{profileId}")
	public Profile findProfileById(@PathVariable("profileId") long id){
		
		return profileService.findEntityById(id);
	}
	
}

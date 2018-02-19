package org.project.trackit.service;

import org.project.trackit.model.Profile;

public interface IProfileServie extends IGenericService<Profile>{

	void saveProfile(Profile profile);
	
}

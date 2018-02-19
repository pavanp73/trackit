package org.project.trackit.dao;

import org.project.trackit.model.Profile;

public interface IProfileDao extends IGenericDao<Profile>{

	void saveProfile(Profile profile);
	
}

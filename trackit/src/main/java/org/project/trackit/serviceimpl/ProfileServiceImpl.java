package org.project.trackit.serviceimpl;

import javax.transaction.Transactional;

import org.project.trackit.dao.IProfileDao;
import org.project.trackit.model.Profile;
import org.project.trackit.service.IProfileServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProfileServiceImpl extends GenericServiceImpl<Profile> implements IProfileServie{

	@Autowired
	private IProfileDao profileDao;
	
	@Override
	public void saveProfileWithRole(Profile profile) {
		
		profileDao.saveProfileWithRole(profile);
	}
	
}

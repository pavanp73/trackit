package org.project.trackit.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.project.trackit.model.Role;
import org.project.trackit.model.RolesEnum;
import org.project.trackit.dao.IProfileDao;
import org.project.trackit.dao.IRoleDao;
import org.project.trackit.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ProfileDaoImpl extends GenericDaoImpl<Profile> implements IProfileDao{

	public ProfileDaoImpl() {
		super("PROFILE");
	}
	
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public void saveProfileWithRole(Profile profile) {
		
		String role = profile.getProfileRole();
		System.out.println("Role "+role);
		List<Role> roleList = new ArrayList<Role>();
		
		if(role == null) {
			roleList.add(roleDao.findByRole("USER"));
		}
		else {
			if(role.equalsIgnoreCase(RolesEnum.ADMIN.name())) {
				roleList.add(roleDao.findByRole(role));
			}
			if(role.equalsIgnoreCase(RolesEnum.USER.name())) {
				roleList.add(roleDao.findByRole(role));
			}
		}
		System.out.println(roleList);
		profile.setRoles(new HashSet<Role>(roleList));
		saveEntity(profile);	
	}

}

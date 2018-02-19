package org.project.trackit.dao;

import org.project.trackit.model.Role;

public interface IRoleDao extends IGenericDao<Role>{

	Role fingByRole(String role);
	
}

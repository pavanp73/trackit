package org.project.trackit.service;

import javax.transaction.Transactional;

import org.project.trackit.model.Role;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role> implements IRoleService{
	
}

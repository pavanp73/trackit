package org.project.trackit.service.impl;

import javax.transaction.Transactional;

import org.project.trackit.model.Role;
import org.project.trackit.service.IRoleService;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role> implements IRoleService{
	
}

package org.project.trackit.controller;

import java.util.List;

import org.project.trackit.model.Role;
import org.project.trackit.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping
	public String saveRole(@RequestBody Role role){
		
		roleService.saveEntity(role);
		return "Role has been added with id "+ role.getRoleId();
	}
	
	@GetMapping
	public List<Role> getRoleList(){
		
		return roleService.getEntityList();
	}
	
	@GetMapping("/{roleId}")
	public Role findRoleById(@PathVariable("roleId") long id){
		
		return roleService.findEntityById(id);
	}
}

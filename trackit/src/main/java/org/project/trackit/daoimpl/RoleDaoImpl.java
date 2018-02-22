package org.project.trackit.daoimpl;

import javax.transaction.Transactional;

import org.project.trackit.dao.IRoleDao;
import org.project.trackit.model.Role;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements IRoleDao{

	public RoleDaoImpl() {
		super("ROLE");
	}
	
	@Override
	public Role findByRole(String role) {
		
		String sql = "from "+tableName+" R where R.role=:role";
		
		return entityManager.createQuery(sql, Role.class)
				.setParameter("role", role)
				.getSingleResult();
	}
	
	public Role findRoleById(long roleId) {
		String sql = "from "+tableName+" R where R.roleId=:roleId";
		
		return entityManager.createQuery(sql, Role.class)
				.setParameter("roleId", roleId)
				.getSingleResult();
	}
	

}

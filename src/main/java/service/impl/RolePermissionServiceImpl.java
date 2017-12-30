package service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RolePermissionMapper;
import entity.RolePermission;
import service.RolePermissionService;
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionMapper rolePermissionMapper;
	@Override
	public List<RolePermission> selectByRoleId(BigInteger roleId) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.selectByRoleId(roleId);
	}

	@Override
	public int editRolePermission(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.updateByPrimaryKeySelective(rolePermission);
	}

	@Override
	public int insertRolePermission(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.insertSelective(rolePermission);
	}

	@Override
	public int deleteRolePermission(int id) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteRolePermissions(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			rolePermissionMapper.deleteByPrimaryKey(ids[i]);
		}
	}

}

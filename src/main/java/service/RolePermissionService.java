package service;
import java.math.BigInteger;
import java.util.List;

import entity.RolePermission;
import entity.RolePermission;

public interface RolePermissionService {
	/**
	 * 按照roleid查找角色权限
	 * @param roleId
	 * @return
	 */
	List<RolePermission> selectByRoleId(BigInteger roleId);
	/**
	 * 修改一位角色
	 * @param rolePermission
	 */
	int editRolePermission(RolePermission rolePermission);
	/**
	 * 添加一位角色
	 * @param rolePermission
	 */
	int insertRolePermission(RolePermission rolePermission);
	
	/**
	 * 删除一位角色
	 * @param id
	 */
	int deleteRolePermission(int id);
	
	/**
	 * 批量删除角色
	 * @param ids
	 */
	void deleteRolePermissions(int[] ids);
}

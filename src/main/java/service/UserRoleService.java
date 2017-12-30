package service;
import java.math.BigInteger;
import java.util.List;

import entity.UserRole;
import util.Page;

public interface UserRoleService {
	List<UserRole> listUserRole(UserRole userRole, Page page);
	/**
	 * 修改一位角色
	 * @param userRole
	 */
	int editUserRole(UserRole userRole);
	/**
	 * 添加一位角色
	 * @param userRole
	 */
	int insertUserRole(UserRole userRole);
	
	/**
	 * 删除一位角色
	 * @param id
	 */
	int deleteUserRole(BigInteger id);
	
	/**
	 * 批量删除角色
	 * @param ids
	 */
	void deleteUserRoles(BigInteger[] ids);
	
	/**
	 * 根据ID获取角色信息
	 * @param id
	 * @return
	 */
	UserRole getUserRoleByID(BigInteger id);
	/**
	 * 查询全部角色
	 * @return
	 */
	List<UserRole> selectAll();
}

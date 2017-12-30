package service;
import java.util.List;

import entity.UserPermission;
import util.Page;

public interface UserPermissionService {
	/**
	 * 批量导入权限信息
	 * @param file
	 */
	List<UserPermission> listUserPermission(UserPermission userPermission, Page page);
	/**
	 * 修改一位权限
	 * @param userPermission
	 */
	int editUserPermission(UserPermission userPermission);
	/**
	 * 添加一位权限
	 * @param userPermission
	 */
	int insertUserPermission(UserPermission userPermission);
	
	/**
	 * 删除一位权限
	 * @param id
	 */
	int deleteUserPermission(int id);
	
	/**
	 * 批量删除权限
	 * @param ids
	 */
	void deleteUserPermissions(int[] ids);
	
	/**
	 * 根据ID获取权限信息
	 * @param id
	 * @return
	 */
	UserPermission getUserPermissionByID(int id);
	/**
	 * 查询全部权限
	 * @return
	 */
	List<UserPermission> selectAll();
}

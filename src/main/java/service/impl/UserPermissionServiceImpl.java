package service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserPermissionMapper;
import entity.UserPermission;
import service.UserPermissionService;
import util.Page;
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

	@Autowired
	UserPermissionMapper userPermissionMapper;
	/**
	 * 根据输入信息条件查询角色列表，并分页显示
	 * @param userPermission
	 * @param page
	 * @return
	 */
	@Override
	public List<UserPermission> listUserPermission(UserPermission userPermission, Page page) {
		int totalNumber = userPermissionMapper.countUserPermission(userPermission);
		page.setTotalNumber(totalNumber);
		List<UserPermission> userPermissions = userPermissionMapper.listUserPermission(userPermission, page);
		return userPermissions;
	}
	/**
	 * 添加一条权限
	 * @param userPermission
	 */
	@Override
	public int insertUserPermission(UserPermission userPermission) {
		// TODO Auto-generated method stub
		return userPermissionMapper.insertSelective(userPermission);

	}
	/**
	 * 修改一条权限
	 * @param userPermission
	 */
    @Override
    public int editUserPermission(UserPermission userPermission) {
    	// TODO Auto-generated method stub
    	return userPermissionMapper.updateByPrimaryKey(userPermission);
    }

	/**
	 * 删除一条权限
	 * @param id
	 */
	@Override
	public int deleteUserPermission(int id) {
		// TODO Auto-generated method stub
		return userPermissionMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除角色
	 * @param ids
	 */
	@Override
	public void deleteUserPermissions(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			userPermissionMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	/**
	 * 根据ID获取角色信息
	 * @param id
	 * @return
	 */
	@Override
	public UserPermission getUserPermissionByID(int id) {
		// TODO Auto-generated method stub
		return userPermissionMapper.selectByPrimaryKey(id);
	}
	/**
	 * 查询全部角色
	 * @return
	 */
	@Override
	public List<UserPermission> selectAll() {
		// TODO Auto-generated method stub
		return userPermissionMapper.selectAll();
	}
}

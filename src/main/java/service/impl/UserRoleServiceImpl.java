package service.impl;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserRoleMapper;
import entity.UserRole;
import service.UserRoleService;
import util.Page;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleMapper userRoleMapper;
	/**
	 * 根据输入信息条件查询角色列表，并分页显示
	 * @param userRole
	 * @param page
	 * @return
	 */
	@Override
	public List<UserRole> listUserRole(UserRole userRole, Page page) {
		int totalNumber = userRoleMapper.countUserRole(userRole);
		page.setTotalNumber(totalNumber);
		List<UserRole> userRoles = userRoleMapper.listUserRole(userRole, page);
		return userRoles;
	}
	/**
	 * 添加一位角色
	 * @param userRole
	 */
	@Override
	public int insertUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleMapper.insertSelective(userRole);

	}
	/**
	 * 修改一位角色
	 * @param userRole
	 */
    @Override
    public int editUserRole(UserRole userRole) {
    	// TODO Auto-generated method stub
    	return userRoleMapper.updateByPrimaryKey(userRole);
    }

	/**
	 * 删除一位角色
	 * @param id
	 */
	@Override
	public int deleteUserRole(BigInteger id) {
		// TODO Auto-generated method stub
		return userRoleMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除角色
	 * @param ids
	 */
	@Override
	public void deleteUserRoles(BigInteger[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			userRoleMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	/**
	 * 根据ID获取角色信息
	 * @param id
	 * @return
	 */
	@Override
	public UserRole getUserRoleByID(BigInteger id) {
		// TODO Auto-generated method stub
		return userRoleMapper.selectByPrimaryKey(id);
	}
	/**
	 * 查询全部角色
	 * @return
	 */
	@Override
	public List<UserRole> selectAll() {
		// TODO Auto-generated method stub
		return userRoleMapper.selectAll();
	}
}

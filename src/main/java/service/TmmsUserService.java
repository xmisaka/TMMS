package service;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import entity.TmmsUser;
import util.Page;

public interface TmmsUserService {
	/**
	 * 按照用户名得到用户信息
	 * @param userName
	 * @return
	 */
    public TmmsUser getByUserName(String username);
    /**
     * 按照用户名得到角色信息
     * @param userName
     * @return
     */
	public Set<String> getRoles(String username);
	/**
	 * 按到用户名得到权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String username);
	/**
	 * 根据输入信息条件查询用户列表，并分页显示
	 * @param tmmsUser
	 * @param page
	 * @return
	 */
	List<TmmsUser> listTmmsUser(TmmsUser tmmsUser, Page page);
	/**
	 * 批量导入用户信息
	 * @param file
	 */
	void uploadTmmsUserjxl(File file);
	/**
	 * 按条件查询用户信息
	 * @param tmmsUser
	 */
	List<TmmsUser> selectByParams(TmmsUser tmmsUser);
	/**
	 * 批量导出用户信息
	 * @param list
	 * @param response
	 */
	void exportTmmsUser(List<TmmsUser> list,HttpServletResponse response);
	
	/**
	 * 修改一位用户
	 * @param tmmsUser
	 */
	int editTmmsUser(TmmsUser tmmsUser);
	/**
	 * 添加一位用户
	 * @param tmmsUser
	 */
	int insertTmmsUser(TmmsUser tmmsUser);
	
	/**
	 * 删除一位用户
	 * @param id
	 */
	int deleteTmmsUser(int id);
	
	/**
	 * 批量删除用户
	 * @param ids
	 */
	void deleteTmmsUsers(int[] ids);
	
	/**
	 * 根据ID获取用户信息
	 * @param id
	 * @return
	 */
	TmmsUser getTmmsUserByID(int id);
}

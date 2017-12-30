package service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import dao.TmmsUserMapper;
import dao.UserPermissionMapper;
import entity.TmmsUser;
import entity.UserPermission;
import exception.ExcelException;
import service.TmmsUserService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class TmmsUserServiceImpl implements TmmsUserService {

	@Autowired
	TmmsUserMapper tmmsUserMapper;
	@Autowired
	UserPermissionMapper userPermissionMapper;
	/**
	 * 按照用户名得到用户信息
	 * @param userName
	 * @return
	 */
 	@CachePut(value="userCache")
	@Override
    public TmmsUser getByUserName(String username){
		return tmmsUserMapper.getByUserName(username);
	}
    /**
     * 按照用户名得到角色信息
     * @param userName
     * @return
     */
    @Override
	public Set<String> getRoles(String username){
    	return tmmsUserMapper.getRoles(username);
    }
	/**
	 * 按到用户名得到权限信息
	 * @param userName
	 * @return
	 */
 	@CachePut(value="userCache")
	@Override
	public Set<String> getPermissions(String username){
		Set<String> set1=tmmsUserMapper.getPermissions(username);
		Set<String> set2=new HashSet<String>();
		for(String permissionid:set1){
			UserPermission userPermission=userPermissionMapper.selectByPrimaryKey(Integer.parseInt(permissionid));
			set2.add(userPermission.getPermissionName());
		}
		return set2;
	}
	/**
	 * 根据输入信息条件查询用户列表，并分页显示
	 * @param tmmsUser
	 * @param page
	 * @return
	 */
 	@CachePut(value="userCache")
	@Override
	public List<TmmsUser> listTmmsUser(TmmsUser tmmsUser, Page page) {
		int totalNumber = tmmsUserMapper.countTmmsUser(tmmsUser);
		page.setTotalNumber(totalNumber);
		List<TmmsUser> tmmsUsers = tmmsUserMapper.listTmmsUser(tmmsUser, page);
		return tmmsUsers;
	}
	/**
	 * 批量导入用户信息
	 * @param file
	 */
	@Override
	public void uploadTmmsUserjxl(File file){//使用jxl导入excel
		List<TmmsUser> list=new ArrayList<TmmsUser>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("用户名", "username");
			fieldMap.put("密码", "password");
			fieldMap.put("角色ID", "roleId");
			fieldMap.put("状态", "state");
			String uniqueFields[]={"用户名"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", TmmsUser.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(TmmsUser tmmsUserinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			tmmsUserinfo.setCreateTime(createtime);//创建时间
			tmmsUserinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			tmmsUserMapper.insertTmmsUserBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询用户信息
	 * @param tmmsUser
	 */
	@Override
	public List<TmmsUser> selectByParams(TmmsUser tmmsUser){
		return tmmsUserMapper.selectByParams(tmmsUser);
	}
	/**
	 * 批量导出用户信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportTmmsUser(List<TmmsUser> list,HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("username", "用户名");
		fieldMap.put("password", "密码");
		fieldMap.put("roleId", "角色ID");
		fieldMap.put("state", "状态");
		fieldMap.put("createTime", "创建时间");
		fieldMap.put("updateTime", "更新时间");
		
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "用户信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加一位用户
	 * @param tmmsUser
	 */
	@Override
	public int insertTmmsUser(TmmsUser tmmsUser) {
		// TODO Auto-generated method stub
		return tmmsUserMapper.insertSelective(tmmsUser);

	}
	/**
	 * 修改一位用户
	 * @param tmmsUser
	 */
    @Override
    public int editTmmsUser(TmmsUser tmmsUser) {
    	// TODO Auto-generated method stub
    	return tmmsUserMapper.updateByPrimaryKey(tmmsUser);
    }

	/**
	 * 删除一位用户
	 * @param id
	 */
	@Override
	public int deleteTmmsUser(int id) {
		// TODO Auto-generated method stub
		return tmmsUserMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除用户
	 * @param ids
	 */
	@Override
	public void deleteTmmsUsers(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			tmmsUserMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	/**
	 * 根据ID获取用户信息
	 * @param id
	 * @return
	 */
	@Override
	public TmmsUser getTmmsUserByID(int id) {
		// TODO Auto-generated method stub
		return tmmsUserMapper.selectByPrimaryKey(id);
	}
}

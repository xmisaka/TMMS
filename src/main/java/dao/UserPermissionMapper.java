package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserPermission;
import util.Page;

public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
    // 下面为自定义方法
  	List<UserPermission> listUserPermission(@Param("userPermission") UserPermission userPermission, @Param("page") Page page);
  	
  	//按条件查询权限信息
  	List<UserPermission> selectByParams(@Param("userPermission") UserPermission userPermission);
  	
  	int countUserPermission(UserPermission userPermission);
  //查询全部
   	List<UserPermission> selectAll();
}
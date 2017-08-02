package dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserRole;
import util.Page;

public interface UserRoleMapper {
    int deleteByPrimaryKey(BigInteger id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(BigInteger id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
 // 下面为自定义方法
  	List<UserRole> listUserRole(@Param("userRole") UserRole userRole, @Param("page") Page page);
  	
  	//按条件查询角色信息
  	List<UserRole> selectByParams(@Param("userRole") UserRole userRole);
  	
  	int countUserRole(UserRole userRole);
  //查询全部
   	List<UserRole> selectAll();
}
package dao;

import java.math.BigInteger;
import java.util.List;

import entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);
    
    List<RolePermission> selectByRoleId(BigInteger roleId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}
package dao;

import java.util.List;

import entity.Menuitem;

public interface MenuitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menuitem record);

    int insertSelective(Menuitem record);

    Menuitem selectByPrimaryKey(Integer id);
    
    List<Menuitem> selectByParentId(Integer parentId);

    int updateByPrimaryKeySelective(Menuitem record);

    int updateByPrimaryKey(Menuitem record);
}
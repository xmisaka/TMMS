package dao;

import entity.TmmsUser;

public interface TmmsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmmsUser record);

    int insertSelective(TmmsUser record);

    TmmsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmmsUser record);

    int updateByPrimaryKey(TmmsUser record);
}
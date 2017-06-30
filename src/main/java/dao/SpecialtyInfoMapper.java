package dao;

import entity.SpecialtyInfo;

public interface SpecialtyInfoMapper {
    int deleteByPrimaryKey(String specialtyId);

    int insert(SpecialtyInfo record);

    int insertSelective(SpecialtyInfo record);

    SpecialtyInfo selectByPrimaryKey(String specialtyId);

    int updateByPrimaryKeySelective(SpecialtyInfo record);

    int updateByPrimaryKey(SpecialtyInfo record);
}
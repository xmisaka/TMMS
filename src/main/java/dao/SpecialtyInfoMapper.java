package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.SpecialtyInfo;
import util.Page;

public interface SpecialtyInfoMapper {
    int deleteByPrimaryKey(String specialtyId);

    int insert(SpecialtyInfo record);

    int insertSelective(SpecialtyInfo record);

    SpecialtyInfo selectByPrimaryKey(String specialtyId);

    int updateByPrimaryKeySelective(SpecialtyInfo record);

    int updateByPrimaryKey(SpecialtyInfo record);
    //下面为自定义方法
  	List<SpecialtyInfo> listSpecialty(@Param("specialtyInfo") SpecialtyInfo specialtyInfo, @Param("page") Page page);
  	//按条件查询专业信息
    List<SpecialtyInfo> selectByParams(@Param("specialtyInfo") SpecialtyInfo specialtyInfo);
     
  	int countSpecialty(SpecialtyInfo specialtyInfo);
  	//批量插入专业信息
  	void insertSpecialtyBatch(List<SpecialtyInfo> list);
  	
  	List<SpecialtyInfo> selectByCollegeId(String collegeId);
  	
}
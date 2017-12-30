package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ClassInfo;
import util.Page;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(String classId);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(String classId);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
    // 下面为自定义方法
 	List<ClassInfo> listClass(@Param("classInfo") ClassInfo classInfo, @Param("page") Page page);
 	//按条件查询院系信息
    List<ClassInfo> selectByParams(@Param("classInfo") ClassInfo classInfo);
    
 	int countClass(ClassInfo classInfo);
 	//批量插入院系信息
 	void insertClassBatch(List<ClassInfo> list);
 	
 	List<ClassInfo> selectBySpecialtyId(String specialtyId);
}
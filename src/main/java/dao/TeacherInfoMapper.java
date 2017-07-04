package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.TeacherInfo;
import entity.TeacherInfo;
import util.Page;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
 // 下面为自定义方法
 	List<TeacherInfo> listTeacher(@Param("teacherInfo") TeacherInfo teacherInfo, @Param("page") Page page);
 	
 	//按条件查询教师信息
 	List<TeacherInfo> selectByParams(@Param("teacherInfo") TeacherInfo teacherInfo);
 	
 	int countTeacher(TeacherInfo bookInfo);
 	//批量插入教师信息
 	void insertTeacherBatch(List<TeacherInfo> list);
}
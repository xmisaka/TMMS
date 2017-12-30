package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.CourseInfo;
import util.Page;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
    // 下面为自定义方法
 	List<CourseInfo> listCourse(@Param("courseInfo") CourseInfo courseInfo, @Param("page") Page page);
 	//按条件查询课程信息
    List<CourseInfo> selectByParams(@Param("courseInfo") CourseInfo courseInfo);
    
 	int countCourse(CourseInfo courseInfo);
 	//批量插入课程信息
 	void insertCourseBatch(List<CourseInfo> list);
}
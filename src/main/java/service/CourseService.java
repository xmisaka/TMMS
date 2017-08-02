package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.CourseInfo;
import util.Page;

public interface CourseService {
	/**
	 * 根据输入信息条件查询课程列表，并分页显示
	 * @param courseInfo
	 * @param page
	 * @return
	 */
	List<CourseInfo> listCourse(CourseInfo courseInfo, Page page);
	
	/**
	 * 批量导入课程信息
	 * @param file
	 */
	//void uploadCourse(File file);
	/**
	 * 批量导入课程信息
	 * @param file
	 */
	void uploadCoursejxl(File file);
	/**
	 * 按条件查询课程信息
	 * @param courseInfo
	 */
	List<CourseInfo> selectByParams(CourseInfo courseInfo);
	/**
	 * 批量导出课程信息
	 * @param list
	 * @param response
	 */
	void exportCourse(List<CourseInfo> list,HttpServletResponse response);
	
	/**
	 * 修改一本课程
	 * @param courseInfo
	 */
	int editCourse(CourseInfo courseInfo);
	/**
	 * 添加一本课程
	 * @param courseInfo
	 */
	int insertCourse(CourseInfo courseInfo);
	
	/**
	 * 删除一本课程
	 * @param id
	 */
	int deleteCourse(int id);
	
	/**
	 * 批量删除课程
	 * @param ids
	 */
	void deleteCourses(int[] ids);
	
	/**
	 * 根据ID获取课程信息
	 * @param id
	 * @return
	 */
	CourseInfo getCourseByID(int id);
}

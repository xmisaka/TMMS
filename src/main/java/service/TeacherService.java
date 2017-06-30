package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.TeacherInfo;
import util.Page;

public interface TeacherService {
	/**
	 * 根据输入信息条件查询教师列表，并分页显示
	 * @param teacherInfo
	 * @param page
	 * @return
	 */
	List<TeacherInfo> listTeacher(TeacherInfo teacherInfo, Page page);
	
	/**
	 * 批量导入教师信息
	 * @param file
	 */
	//void uploadTeacher(File file);
	/**
	 * 批量导入教师信息
	 * @param file
	 */
	void uploadTeacherjxl(File file);
	/**
	 * 按条件查询教师信息
	 * @param teacherInfo
	 */
	List<TeacherInfo> selectByParams(TeacherInfo teacherInfo);
	/**
	 * 批量导出教师信息
	 * @param list
	 * @param response
	 */
	void exportTeacher(List<TeacherInfo> list,HttpServletResponse response);
	
	/**
	 * 修改一本教师
	 * @param teacherInfo
	 */
	int editTeacher(TeacherInfo teacherInfo);
	/**
	 * 添加一本教师
	 * @param teacherInfo
	 */
	int insertTeacher(TeacherInfo teacherInfo);
	
	/**
	 * 删除一本教师
	 * @param id
	 */
	int deleteTeacher(int id);
	
	/**
	 * 批量删除教师
	 * @param ids
	 */
	void deleteTeachers(int[] ids);
	
	/**
	 * 根据ID获取教师信息
	 * @param id
	 * @return
	 */
	TeacherInfo getTeacherByID(int id);
}

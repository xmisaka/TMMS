package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.ClassInfo;
import util.Page;

public interface ClassService {
	/**
	 * 根据输入信息条件查询班级列表，并分页显示
	 * @param classInfo
	 * @param page
	 * @return
	 */
	List<ClassInfo> listClass(ClassInfo classInfo, Page page);
	
	/**
	 * 批量导入班级信息
	 * @param file
	 */
	//void uploadClass(File file);
	/**
	 * 批量导入班级信息
	 * @param file
	 */
	void uploadClassjxl(File file);
	/**
	 * 按条件查询班级信息
	 * @param classInfo
	 * @return
	 */
	List<ClassInfo> selectByParams(ClassInfo classInfo);
	/**
	 * 批量导出班级信息
	 * @param list
	 * @param response
	 */
	void exportClass(List<ClassInfo> list,HttpServletResponse response);
	/**
	 * 修改一条班级信息
	 * @param classInfo
	 * @return
	 */
	int editClass(ClassInfo classInfo);
	/**
	 * 添加一条班级信息
	 * @param bookInfo
	 */
	int insertClass(ClassInfo classInfo);
	
	/**
	 * 删除一条班级信息
	 * @param id
	 */
	int deleteClass(String classId);
	
	/**
	 * 批量删除班级信息
	 * @param ids
	 */
	void deleteClasss(String[] classIds);
	
	/**
	 * 根据ID获取班级信息
	 * @param id
	 * @return
	 */
	ClassInfo getClassByID(String classId);
	/**
	 * 根据specialtyId查找班级
	 * @param specialtyId
	 * @return
	 */
	List<ClassInfo> selectBySpecialtyId(String specialtyId);
}

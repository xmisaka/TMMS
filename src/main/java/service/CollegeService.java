package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.CollegeInfo;
import util.Page;

public interface CollegeService {
	/**
	 * 根据输入信息条件查询院系列表，并分页显示
	 * @param studentInfo
	 * @param page
	 * @return
	 */
	List<CollegeInfo> listCollege(CollegeInfo studentInfo, Page page);
	
	/**
	 * 批量导入院系信息
	 * @param file
	 */
	//void uploadCollege(File file);
	/**
	 * 批量导入院系信息
	 * @param file
	 */
	void uploadCollegejxl(File file);
	/**
	 * 按条件查询院系信息
	 * @param studentInfo
	 * @return
	 */
	List<CollegeInfo> selectByParams(CollegeInfo studentInfo);
	/**
	 * 批量导出院系信息
	 * @param list
	 * @param response
	 */
	void exportCollege(List<CollegeInfo> list,HttpServletResponse response);
	/**
	 * 修改一条院系信息
	 * @param studentInfo
	 * @return
	 */
	int editCollege(CollegeInfo studentInfo);
	/**
	 * 添加一条院系信息
	 * @param bookInfo
	 */
	int insertCollege(CollegeInfo studentInfo);
	
	/**
	 * 删除一条院系信息
	 * @param id
	 */
	int deleteCollege(String collegeId);
	
	/**
	 * 批量删除院系信息
	 * @param ids
	 */
	void deleteColleges(String[] collegeIds);
	
	/**
	 * 根据ID获取院系信息
	 * @param id
	 * @return
	 */
	CollegeInfo getCollegeByID(String collegeId);
}

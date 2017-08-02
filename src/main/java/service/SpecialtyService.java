package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.SpecialtyInfo;
import util.Page;

public interface SpecialtyService {
	/**
	 * 根据输入信息条件查询专业列表，并分页显示
	 * @param specialtyInfo
	 * @param page
	 * @return
	 */
	List<SpecialtyInfo> listSpecialty(SpecialtyInfo specialtyInfo, Page page);
	
	/**
	 * 批量导入专业信息
	 * @param file
	 */
	//void uploadSpecialty(File file);
	/**
	 * 批量导入专业信息
	 * @param file
	 */
	void uploadSpecialtyjxl(File file);
	/**
	 * 按条件查询专业信息
	 * @param specialtyInfo
	 * @return
	 */
	List<SpecialtyInfo> selectByParams(SpecialtyInfo specialtyInfo);
	/**
	 * 批量导出专业信息
	 * @param list
	 * @param response
	 */
	void exportSpecialty(List<SpecialtyInfo> list,HttpServletResponse response);
	/**
	 * 修改一条专业信息
	 * @param specialtyInfo
	 * @return
	 */
	int editSpecialty(SpecialtyInfo specialtyInfo);
	/**
	 * 添加一条专业信息
	 * @param bookInfo
	 */
	int insertSpecialty(SpecialtyInfo specialtyInfo);
	
	/**
	 * 删除一条专业信息
	 * @param id
	 */
	int deleteSpecialty(String specialtyId);
	
	/**
	 * 批量删除专业信息
	 * @param ids
	 */
	void deleteSpecialtys(String[] specialtyIds);
	
	/**
	 * 根据ID获取专业信息
	 * @param id
	 * @return
	 */
	SpecialtyInfo getSpecialtyByID(String specialtyId);
	/**
	 * 根据collegeId查找专业
	 * @param collegeId
	 * @return
	 */
	List<SpecialtyInfo> selectByCollegeId(String collegeId);
}

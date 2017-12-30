package service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseInfoMapper;
import entity.CourseInfo;
import exception.ExcelException;
import service.CourseService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseInfoMapper courseInfoMapper;
	/**
	 * 根据输入信息条件查询课程列表，并分页显示
	 * @param courseInfo
	 * @param page
	 * @return
	 */
	@Override
	public List<CourseInfo> listCourse(CourseInfo courseInfo, Page page) {
		int totalNumber = courseInfoMapper.countCourse(courseInfo);
		page.setTotalNumber(totalNumber);
		List<CourseInfo> courses = courseInfoMapper.listCourse(courseInfo, page);
		return courses;
	}
	/**
	 * 批量导入课程信息
	 * @param file
	 */
	//@Override
	/*public void uploadCourse(File file) {
		// TODO Auto-generated method stub
		List<CourseInfo> list=new ArrayList<CourseInfo>();//存放每条数据的List
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkcourse wbs = new HSSFWorkcourse(is);//读取excel表格
			HSSFSheet childSheet = wbs.getSheetAt(0);//获取该excel中第一个sheet
			if(childSheet.getLastRowNum()>1){
				for (int i = 1; i <= childSheet.getLastRowNum(); i++) {//从1开始，排除表头
					HSSFRow row = childSheet.getRow(i);//获取第i行数据
					CourseInfo courseinfo=new CourseInfo();
					if(row!=null){
						Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
						courseinfo.setCreateTime(createtime);//创建时间
						courseinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
						for(int j=0;j<row.getLastCellNum();j++){
							HSSFCell cell=row.getCell((short)j,Row.RETURN_NULL_AND_BLANK);//获取第i行第j列数据
							if (null != cell) {
	                            switch (cell.getCellType()) {   
	                            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
	                            	String value = "";
	                            	if(HSSFDateUtil.isCellDateFormatted(cell)){
	                            		double d = cell.getNumericCellValue();
	                            		Date date = HSSFDateUtil.getJavaDate(d);
	                            		value = DateUtil.format(date);
	                            	}else{
	                            		value = String.valueOf(cell.getNumericCellValue());
	                            	}
	                            	if(j==0){//书名
	                            		courseinfo.setCourseName(value.substring(0,value.indexOf(".")));
	                            	}else if(j==1){//书的类型
	                            		courseinfo.setCourseKind(value.substring(0,value.indexOf(".")));
	                            	}else if(j==2){//作者
	                            		courseinfo.setCourseAuthor(value.substring(0,value.indexOf(".")));
	                            	}else if(j==3){//ISBN
	                            		courseinfo.setCourseIsbn(value.substring(0,value.indexOf(".")));
	                            	}else if(j==4){//出版社
	                            		courseinfo.setCoursePublish(value.substring(0,value.indexOf(".")));
	                            	}else if(j==5){//出版时间
	                            		courseinfo.setCoursePublishTime(DateUtil.parseDate(value));
	                            	}else if(j==6){//价格
	                            		courseinfo.setCoursePrice(BigDecimal.valueOf(Double.parseDouble(value.substring(0,value.indexOf(".")))));
	                            	}else if(j==7){//介绍
	                            		courseinfo.setCourseIntro(value.substring(0,value.indexOf(".")));
	                            	}
	                                break;   
	                            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                            	String value2 = "";
	                            		value2 = cell.getStringCellValue();
	                            		if(j==0){//书名
	                                		courseinfo.setCourseName(value2);
	                                	}else if(j==1){//书的类型
	                                		courseinfo.setCourseKind(value2);
	                                	}else if(j==2){//作者
	                                		courseinfo.setCourseAuthor(value2);
	                                	}else if(j==3){//ISBN
	                                		courseinfo.setCourseIsbn(value2);
	                                	}else if(j==4){//出版社
	                                		courseinfo.setCoursePublish(value2);
	                                	}else if(j==5){//出版时间
	                                		courseinfo.setCoursePublishTime(DateUtil.parseDate(value2));
	                                	}else if(j==6){//价格
	                                		courseinfo.setCoursePrice(BigDecimal.valueOf(Double.parseDouble(value2)));
	                                	}else if(j==7){//介绍
	                                		courseinfo.setCourseIntro(value2);
	                                	}
	                                break; 
	                            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean   
	                                //System.out.println("Boolean："+cell.getBooleanCellValue()   + "   ");   
	                                break;   
	                            case HSSFCell.CELL_TYPE_FORMULA: // 公式   
	                               // System.out.print("公式："+cell.getCellFormula() + "   ");   
	                                break;   
	                            case HSSFCell.CELL_TYPE_BLANK: // 空值   
	                                //System.out.println(" 空值 ");   
	                                break;   
	                            case HSSFCell.CELL_TYPE_ERROR: // 故障   
	                               // System.out.println("故障 ");   
	                                break;   
	                            default:   
	                                System.out.print("未知类型   ");   
	                                break;   
	                            }   
	                        }else{
	                        	 continue;
	                        } 
						}
					}else{
						continue;
					}
				    list.add(courseinfo);//list中加入一条数据
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(list.size()>0){
				courseInfoMapper.insertCourseBatch(list);//批量插入数据
			}
		}
	}*/
	/**
	 * 批量导入课程信息
	 * @param file
	 */
	@Override
	public void uploadCoursejxl(File file){//使用jxl导入excel
		List<CourseInfo> list=new ArrayList<CourseInfo>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("课程号", "courseNo");
			fieldMap.put("课程名", "courseName");
			fieldMap.put("年级", "courseGrade");
			fieldMap.put("学期", "courseTerm");
			fieldMap.put("所属学院", "collegeId");
			fieldMap.put("所属专业", "specialtyId");
			fieldMap.put("课程类型", "courseKind");
			String uniqueFields[]={"课程号"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", CourseInfo.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CourseInfo courseinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			courseinfo.setCreatetime(createtime);//创建时间
			courseinfo.setUpdatetime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			courseInfoMapper.insertCourseBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询课程信息
	 * @param courseInfo
	 */
	@Override
	public List<CourseInfo> selectByParams(CourseInfo courseInfo){
		return courseInfoMapper.selectByParams(courseInfo);
	}
	/**
	 * 批量导出课程信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportCourse(List<CourseInfo> list,HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("courseNo", "课程号");
		fieldMap.put("courseName", "课程名");
		fieldMap.put("courseGrade", "年级");
		fieldMap.put("courseTerm", "学期");
		fieldMap.put("collegeId", "所属学院");
		fieldMap.put("specialtyId", "所属专业");
		fieldMap.put("courseKind", "课程类型");
		fieldMap.put("createtime", "创建时间");
		fieldMap.put("updatetime", "更新时间");
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "课程信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加一本课程
	 * @param courseInfo
	 */
	@Override
	public int insertCourse(CourseInfo courseInfo) {
		// TODO Auto-generated method stub
		return courseInfoMapper.insertSelective(courseInfo);

	}
	/**
	 * 修改一本课程
	 * @param courseInfo
	 */
    @Override
    public int editCourse(CourseInfo courseInfo) {
    	// TODO Auto-generated method stub
    	return courseInfoMapper.updateByPrimaryKey(courseInfo);
    }

	/**
	 * 删除一本课程
	 * @param id
	 */
	@Override
	public int deleteCourse(int id) {
		// TODO Auto-generated method stub
		return courseInfoMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除课程
	 * @param ids
	 */
	@Override
	public void deleteCourses(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			courseInfoMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	/**
	 * 根据ID获取课程信息
	 * @param id
	 * @return
	 */
	@Override
	public CourseInfo getCourseByID(int id) {
		// TODO Auto-generated method stub
		return courseInfoMapper.selectByPrimaryKey(id);
	}
}

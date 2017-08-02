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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClassInfoMapper;
import entity.BookInfo;
import entity.ClassInfo;
import exception.ExcelException;
import service.ClassService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassInfoMapper classInfoMapper;
	/**
	 * 根据输入信息条件查询班级列表，并分页显示
	 * @param bookInfo
	 * @param page
	 * @return
	 */
	@Override
	public List<ClassInfo> listClass(ClassInfo classInfo, Page page) {
		int totalNumber = classInfoMapper.countClass(classInfo);
		page.setTotalNumber(totalNumber);
		List<ClassInfo> classs = classInfoMapper.listClass(classInfo, page);
		return classs;
	}
	/**
	 * 批量导入班级信息
	 * @param file
	 
	@Override
	public void uploadClass(File file) {
		// TODO Auto-generated method stub
		List<ClassInfo> list=new ArrayList<ClassInfo>();//存放每条数据的List
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkbook wbs = new HSSFWorkbook(is);//读取excel表格
			HSSFSheet childSheet = wbs.getSheetAt(0);//获取改excel中第一个sheet
			if(childSheet.getLastRowNum()>1){
				for (int i = 1; i <= childSheet.getLastRowNum(); i++) {//从1开始，排除表头
					HSSFRow row = childSheet.getRow(i);//获取第i行数据
					ClassInfo classInfo=new ClassInfo();
					if(row!=null){
						Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
						classInfo.setCreateTime(createtime);//创建时间
						classInfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
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
	                            	if(j==0){//学号
	                            		classInfo.setClassNo(value.substring(0,value.indexOf(".")));
	                            	}else if(j==1){//班级姓名
	                            		classInfo.setClassName(value.substring(0,value.indexOf(".")));
	                            	}else if(j==2){//性别
	                            		classInfo.setClassSex(value.substring(0,value.indexOf(".")));
	                            	}else if(j==3){//手机号
	                            		classInfo.setMobile(value.substring(0,value.indexOf(".")));
	                            	}else if(j==4){//密码
	                            		classInfo.setClassPwd(value.substring(0,value.indexOf(".")));
	                            	}else if(j==5){//年级
	                            		classInfo.setClassGrade(value.substring(0,value.indexOf(".")));
	                            	}else if(j==6){//班级
	                            		classInfo.setClassId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==7){//专业
	                            		classInfo.setSpecialtyId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==8){//学院
	                            		classInfo.setClassId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==9){//入学时间
	                            		classInfo.setEnterTime(DateUtil.parseDate(value));
	                            	}else if(j==10){//付款状态
	                            		classInfo.setPayStatus(value.substring(0,value.indexOf(".")));
	                            	}else if(j==11){//初始缴费金额
	                            		classInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value.substring(0,value.indexOf(".")))));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		classInfo.setState(Byte.valueOf(value));
	                            	}
	                                break;   
	                            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                            	String value2 = "";
	                        		value2 = cell.getStringCellValue();
	                        		if(j==0){//学号
	                            		classInfo.setClassNo(value2);
	                            	}else if(j==1){//班级姓名
	                            		classInfo.setClassName(value2);
	                            	}else if(j==2){//性别
	                            		classInfo.setClassSex(value2);
	                            	}else if(j==3){//手机号
	                            		classInfo.setMobile(value2);
	                            	}else if(j==4){//密码
	                            		classInfo.setClassPwd(value2);
	                            	}else if(j==5){//年级
	                            		classInfo.setClassGrade(value2);
	                            	}else if(j==6){//班级
	                            		classInfo.setClassId(value2);
	                            	}else if(j==7){//专业
	                            		classInfo.setSpecialtyId(value2);
	                            	}else if(j==8){//学院
	                            		classInfo.setClassId(value2);
	                            	}else if(j==9){//入学时间
	                            		classInfo.setEnterTime(DateUtil.parseDate(value2));
	                            	}else if(j==10){//付款状态
	                            		classInfo.setPayStatus(value2);
	                            	}else if(j==11){//初始缴费金额
	                            		classInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value2)));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		classInfo.setState(Byte.valueOf(value2));
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
				    list.add(classInfo);//list中加入一条数据
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
				classInfoMapper.insertClassInfoBatch(list);//批量插入数据
			}
		}
	}*/
	/**
	 * 添加一位班级信息
	 * @param bookInfo
	 */
	@Override
	public int insertClass(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		return classInfoMapper.insertSelective(classInfo);

	}
	/**
	 * 修改一位班级信息
	 * @param classInfo
	 * @return
	 */
    @Override
    public int editClass(ClassInfo classInfo) {
    	// TODO Auto-generated method stub
    	return classInfoMapper.updateByPrimaryKey(classInfo);
    }
    /**
	 * 删除一位班级信息
	 * @param id
	 */
	@Override
	public int deleteClass(String classId) {
		// TODO Auto-generated method stub
		return classInfoMapper.deleteByPrimaryKey(classId);
	}

	/**
	 * 批量删除班级信息
	 * @param ids
	 */
	@Override
	public void deleteClasss(String[] classIds) {
		// TODO Auto-generated method stub
		for(int i=0;i<classIds.length;i++){
			classInfoMapper.deleteByPrimaryKey(classIds[i]);
		}
	}

	/**
	 * 根据ID获取班级信息
	 * @param id
	 * @return
	 */
	@Override
	public ClassInfo getClassByID(String classId) {
		// TODO Auto-generated method stub
		return classInfoMapper.selectByPrimaryKey(classId);
	}
	/**
	 * 批量导入班级信息
	 * @param file
	 */
	@Override
	public void uploadClassjxl(File file) {
		// TODO Auto-generated method stub
		List<ClassInfo> list=new ArrayList<ClassInfo>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("班级Id", "classId");
			fieldMap.put("班级名字", "className");
			fieldMap.put("所属学院", "collegeId");
			fieldMap.put("所属专业", "specialtyId");
			fieldMap.put("年级", "grade");
			fieldMap.put("班长学号", "monitorNo");
			fieldMap.put("班长名字", "monitorName");
			fieldMap.put("班长联系方式", "monitorLinkinfo");
			fieldMap.put("学生人数", "studentNum");
			fieldMap.put("已缴费学生数量", "paidStudentNum");
			String uniqueFields[]={"班级Id"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", ClassInfo.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(ClassInfo classinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			classinfo.setClassPwd("123456");//密码
			classinfo.setCreateTime(createtime);//创建时间
			classinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			classInfoMapper.insertClassBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询班级信息
	 * @param classInfo
	 * @return
	 */
	@Override
	public List<ClassInfo> selectByParams(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		return classInfoMapper.selectByParams(classInfo);
	}
	/**
	 * 批量导出班级信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportClass(List<ClassInfo> list, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("classId", "班级Id");
		fieldMap.put("className", "班级名字");
		fieldMap.put("collegeId", "所属学院");
		fieldMap.put("specialtyId", "所属专业");
		fieldMap.put("grade", "年级");
		fieldMap.put("monitorNo", "班长学号");
		fieldMap.put("monitorName", "班长名字");
		fieldMap.put("monitorLinkinfo", "班长联系方式");
		fieldMap.put("studentNum", "学生人数");
		fieldMap.put("paidStudentNum", "已缴费学生数量");
		fieldMap.put("createTime", "创建时间");
		fieldMap.put("updateTime", "更新时间");
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "班级信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<ClassInfo> selectBySpecialtyId(String specialtyId) {
		// TODO Auto-generated method stub
		return classInfoMapper.selectBySpecialtyId(specialtyId);
	}
	 
}

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

import dao.CollegeInfoMapper;
import entity.BookInfo;
import entity.CollegeInfo;
import exception.ExcelException;
import service.CollegeService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeInfoMapper collegeInfoMapper;
	/**
	 * 根据输入信息条件查询院系列表，并分页显示
	 * @param bookInfo
	 * @param page
	 * @return
	 */
	@Override
	public List<CollegeInfo> listCollege(CollegeInfo collegeInfo, Page page) {
		int totalNumber = collegeInfoMapper.countCollege(collegeInfo);
		page.setTotalNumber(totalNumber);
		List<CollegeInfo> colleges = collegeInfoMapper.listCollege(collegeInfo, page);
		return colleges;
	}
	/**
	 * 批量导入院系信息
	 * @param file
	 
	@Override
	public void uploadCollege(File file) {
		// TODO Auto-generated method stub
		List<CollegeInfo> list=new ArrayList<CollegeInfo>();//存放每条数据的List
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkbook wbs = new HSSFWorkbook(is);//读取excel表格
			HSSFSheet childSheet = wbs.getSheetAt(0);//获取改excel中第一个sheet
			if(childSheet.getLastRowNum()>1){
				for (int i = 1; i <= childSheet.getLastRowNum(); i++) {//从1开始，排除表头
					HSSFRow row = childSheet.getRow(i);//获取第i行数据
					CollegeInfo collegeInfo=new CollegeInfo();
					if(row!=null){
						Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
						collegeInfo.setCreateTime(createtime);//创建时间
						collegeInfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
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
	                            		collegeInfo.setCollegeNo(value.substring(0,value.indexOf(".")));
	                            	}else if(j==1){//院系姓名
	                            		collegeInfo.setCollegeName(value.substring(0,value.indexOf(".")));
	                            	}else if(j==2){//性别
	                            		collegeInfo.setCollegeSex(value.substring(0,value.indexOf(".")));
	                            	}else if(j==3){//手机号
	                            		collegeInfo.setMobile(value.substring(0,value.indexOf(".")));
	                            	}else if(j==4){//密码
	                            		collegeInfo.setCollegePwd(value.substring(0,value.indexOf(".")));
	                            	}else if(j==5){//年级
	                            		collegeInfo.setCollegeGrade(value.substring(0,value.indexOf(".")));
	                            	}else if(j==6){//班级
	                            		collegeInfo.setClassId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==7){//专业
	                            		collegeInfo.setSpecialtyId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==8){//学院
	                            		collegeInfo.setCollegeId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==9){//入学时间
	                            		collegeInfo.setEnterTime(DateUtil.parseDate(value));
	                            	}else if(j==10){//付款状态
	                            		collegeInfo.setPayStatus(value.substring(0,value.indexOf(".")));
	                            	}else if(j==11){//初始缴费金额
	                            		collegeInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value.substring(0,value.indexOf(".")))));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		collegeInfo.setState(Byte.valueOf(value));
	                            	}
	                                break;   
	                            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                            	String value2 = "";
	                        		value2 = cell.getStringCellValue();
	                        		if(j==0){//学号
	                            		collegeInfo.setCollegeNo(value2);
	                            	}else if(j==1){//院系姓名
	                            		collegeInfo.setCollegeName(value2);
	                            	}else if(j==2){//性别
	                            		collegeInfo.setCollegeSex(value2);
	                            	}else if(j==3){//手机号
	                            		collegeInfo.setMobile(value2);
	                            	}else if(j==4){//密码
	                            		collegeInfo.setCollegePwd(value2);
	                            	}else if(j==5){//年级
	                            		collegeInfo.setCollegeGrade(value2);
	                            	}else if(j==6){//班级
	                            		collegeInfo.setClassId(value2);
	                            	}else if(j==7){//专业
	                            		collegeInfo.setSpecialtyId(value2);
	                            	}else if(j==8){//学院
	                            		collegeInfo.setCollegeId(value2);
	                            	}else if(j==9){//入学时间
	                            		collegeInfo.setEnterTime(DateUtil.parseDate(value2));
	                            	}else if(j==10){//付款状态
	                            		collegeInfo.setPayStatus(value2);
	                            	}else if(j==11){//初始缴费金额
	                            		collegeInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value2)));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		collegeInfo.setState(Byte.valueOf(value2));
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
				    list.add(collegeInfo);//list中加入一条数据
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
				collegeInfoMapper.insertCollegeInfoBatch(list);//批量插入数据
			}
		}
	}*/
	/**
	 * 添加一位院系信息
	 * @param bookInfo
	 */
	@Override
	public int insertCollege(CollegeInfo collegeInfo) {
		// TODO Auto-generated method stub
		return collegeInfoMapper.insertSelective(collegeInfo);

	}
	/**
	 * 修改一位院系信息
	 * @param collegeInfo
	 * @return
	 */
    @Override
    public int editCollege(CollegeInfo collegeInfo) {
    	// TODO Auto-generated method stub
    	return collegeInfoMapper.updateByPrimaryKey(collegeInfo);
    }
    /**
	 * 删除一位院系信息
	 * @param id
	 */
	@Override
	public int deleteCollege(String collegeId) {
		// TODO Auto-generated method stub
		return collegeInfoMapper.deleteByPrimaryKey(collegeId);
	}

	/**
	 * 批量删除院系信息
	 * @param ids
	 */
	@Override
	public void deleteColleges(String[] collegeIds) {
		// TODO Auto-generated method stub
		for(int i=0;i<collegeIds.length;i++){
			collegeInfoMapper.deleteByPrimaryKey(collegeIds[i]);
		}
	}

	/**
	 * 根据ID获取院系信息
	 * @param id
	 * @return
	 */
	@Override
	public CollegeInfo getCollegeByID(String collegeId) {
		// TODO Auto-generated method stub
		return collegeInfoMapper.selectByPrimaryKey(collegeId);
	}
	/**
	 * 批量导入院系信息
	 * @param file
	 */
	@Override
	public void uploadCollegejxl(File file) {
		// TODO Auto-generated method stub
		List<CollegeInfo> list=new ArrayList<CollegeInfo>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("学院Id", "collegeId");
			fieldMap.put("学院名字", "collegeName");
			fieldMap.put("学院负责人", "collegePrincipal");
			fieldMap.put("所属学校", "school");
			String uniqueFields[]={"学院Id"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", CollegeInfo.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CollegeInfo collegeinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			collegeinfo.setCollegePwd("123456");//密码
			collegeinfo.setCreateTime(createtime);//创建时间
			collegeinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			collegeInfoMapper.insertCollegeBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询院系信息
	 * @param collegeInfo
	 * @return
	 */
	@Override
	public List<CollegeInfo> selectByParams(CollegeInfo collegeInfo) {
		// TODO Auto-generated method stub
		return collegeInfoMapper.selectByParams(collegeInfo);
	}
	/**
	 * 批量导出院系信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportCollege(List<CollegeInfo> list, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("collegeId", "学院号");
		fieldMap.put("collegeName", "学院名字");
		fieldMap.put("collegePwd", "学院密码");
		fieldMap.put("collegePrincipal", "学院负责人");
		fieldMap.put("school", "所属学校");
		fieldMap.put("createTime", "创建时间");
		fieldMap.put("updateTime", "更新时间");
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "院系信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<CollegeInfo> selectAll() {
		// TODO Auto-generated method stub
		return collegeInfoMapper.selectAll();
	}
	 
}

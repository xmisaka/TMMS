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

import dao.SpecialtyInfoMapper;
import entity.BookInfo;
import entity.SpecialtyInfo;
import exception.ExcelException;
import service.SpecialtyService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class SpecialtyServiceImpl implements SpecialtyService {

	@Autowired
	SpecialtyInfoMapper specialtyInfoMapper;
	/**
	 * 根据输入信息条件查询专业列表，并分页显示
	 * @param bookInfo
	 * @param page
	 * @return
	 */
	@Override
	public List<SpecialtyInfo> listSpecialty(SpecialtyInfo specialtyInfo, Page page) {
		int totalNumber = specialtyInfoMapper.countSpecialty(specialtyInfo);
		page.setTotalNumber(totalNumber);
		List<SpecialtyInfo> specialtys = specialtyInfoMapper.listSpecialty(specialtyInfo, page);
		return specialtys;
	}
	/**
	 * 批量导入专业信息
	 * @param file
	 
	@Override
	public void uploadSpecialty(File file) {
		// TODO Auto-generated method stub
		List<SpecialtyInfo> list=new ArrayList<SpecialtyInfo>();//存放每条数据的List
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkbook wbs = new HSSFWorkbook(is);//读取excel表格
			HSSFSheet childSheet = wbs.getSheetAt(0);//获取改excel中第一个sheet
			if(childSheet.getLastRowNum()>1){
				for (int i = 1; i <= childSheet.getLastRowNum(); i++) {//从1开始，排除表头
					HSSFRow row = childSheet.getRow(i);//获取第i行数据
					SpecialtyInfo specialtyInfo=new SpecialtyInfo();
					if(row!=null){
						Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
						specialtyInfo.setCreateTime(createtime);//创建时间
						specialtyInfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
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
	                            		specialtyInfo.setSpecialtyNo(value.substring(0,value.indexOf(".")));
	                            	}else if(j==1){//专业姓名
	                            		specialtyInfo.setSpecialtyName(value.substring(0,value.indexOf(".")));
	                            	}else if(j==2){//性别
	                            		specialtyInfo.setSpecialtySex(value.substring(0,value.indexOf(".")));
	                            	}else if(j==3){//手机号
	                            		specialtyInfo.setMobile(value.substring(0,value.indexOf(".")));
	                            	}else if(j==4){//密码
	                            		specialtyInfo.setSpecialtyPwd(value.substring(0,value.indexOf(".")));
	                            	}else if(j==5){//年级
	                            		specialtyInfo.setSpecialtyGrade(value.substring(0,value.indexOf(".")));
	                            	}else if(j==6){//班级
	                            		specialtyInfo.setClassId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==7){//专业
	                            		specialtyInfo.setSpecialtyId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==8){//学院
	                            		specialtyInfo.setSpecialtyId(value.substring(0,value.indexOf(".")));
	                            	}else if(j==9){//入学时间
	                            		specialtyInfo.setEnterTime(DateUtil.parseDate(value));
	                            	}else if(j==10){//付款状态
	                            		specialtyInfo.setPayStatus(value.substring(0,value.indexOf(".")));
	                            	}else if(j==11){//初始缴费金额
	                            		specialtyInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value.substring(0,value.indexOf(".")))));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		specialtyInfo.setState(Byte.valueOf(value));
	                            	}
	                                break;   
	                            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                            	String value2 = "";
	                        		value2 = cell.getStringCellValue();
	                        		if(j==0){//学号
	                            		specialtyInfo.setSpecialtyNo(value2);
	                            	}else if(j==1){//专业姓名
	                            		specialtyInfo.setSpecialtyName(value2);
	                            	}else if(j==2){//性别
	                            		specialtyInfo.setSpecialtySex(value2);
	                            	}else if(j==3){//手机号
	                            		specialtyInfo.setMobile(value2);
	                            	}else if(j==4){//密码
	                            		specialtyInfo.setSpecialtyPwd(value2);
	                            	}else if(j==5){//年级
	                            		specialtyInfo.setSpecialtyGrade(value2);
	                            	}else if(j==6){//班级
	                            		specialtyInfo.setClassId(value2);
	                            	}else if(j==7){//专业
	                            		specialtyInfo.setSpecialtyId(value2);
	                            	}else if(j==8){//学院
	                            		specialtyInfo.setSpecialtyId(value2);
	                            	}else if(j==9){//入学时间
	                            		specialtyInfo.setEnterTime(DateUtil.parseDate(value2));
	                            	}else if(j==10){//付款状态
	                            		specialtyInfo.setPayStatus(value2);
	                            	}else if(j==11){//初始缴费金额
	                            		specialtyInfo.setInitialAmount(BigDecimal.valueOf(Double.parseDouble(value2)));
	                            	}else if(j==12){//状态(0:在校 1:毕业)
	                            		specialtyInfo.setState(Byte.valueOf(value2));
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
				    list.add(specialtyInfo);//list中加入一条数据
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
				specialtyInfoMapper.insertSpecialtyInfoBatch(list);//批量插入数据
			}
		}
	}*/
	/**
	 * 添加一位专业信息
	 * @param bookInfo
	 */
	@Override
	public int insertSpecialty(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.insertSelective(specialtyInfo);

	}
	/**
	 * 修改一位专业信息
	 * @param specialtyInfo
	 * @return
	 */
    @Override
    public int editSpecialty(SpecialtyInfo specialtyInfo) {
    	// TODO Auto-generated method stub
    	return specialtyInfoMapper.updateByPrimaryKey(specialtyInfo);
    }
    /**
	 * 删除一位专业信息
	 * @param id
	 */
	@Override
	public int deleteSpecialty(String specialtyId) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.deleteByPrimaryKey(specialtyId);
	}

	/**
	 * 批量删除专业信息
	 * @param ids
	 */
	@Override
	public void deleteSpecialtys(String[] specialtyIds) {
		// TODO Auto-generated method stub
		for(int i=0;i<specialtyIds.length;i++){
			specialtyInfoMapper.deleteByPrimaryKey(specialtyIds[i]);
		}
	}

	/**
	 * 根据ID获取专业信息
	 * @param id
	 * @return
	 */
	@Override
	public SpecialtyInfo getSpecialtyByID(String specialtyId) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.selectByPrimaryKey(specialtyId);
	}
	/**
	 * 批量导入专业信息
	 * @param file
	 */
	@Override
	public void uploadSpecialtyjxl(File file) {
		// TODO Auto-generated method stub
		List<SpecialtyInfo> list=new ArrayList<SpecialtyInfo>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("专业Id", "specialtyId");
			fieldMap.put("所属院系Id", "collegeId");
			fieldMap.put("专业名字", "specialtyName");
			fieldMap.put("学制", "schsys");
			String uniqueFields[]={"专业Id"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", SpecialtyInfo.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(SpecialtyInfo specialtyinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			specialtyinfo.setCreateTime(createtime);//创建时间
			specialtyinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			specialtyInfoMapper.insertSpecialtyBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询专业信息
	 * @param specialtyInfo
	 * @return
	 */
	@Override
	public List<SpecialtyInfo> selectByParams(SpecialtyInfo specialtyInfo) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.selectByParams(specialtyInfo);
	}
	/**
	 * 批量导出专业信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportSpecialty(List<SpecialtyInfo> list, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("specialtyId", "专业Id");
		fieldMap.put("collegeId", "所属院系Id");
		fieldMap.put("specialtyName", "专业名字");
		fieldMap.put("schsys", "学制");
		fieldMap.put("createTime", "创建时间");
		fieldMap.put("updateTime", "更新时间");
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "专业信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据collegeId查找专业
	 * @param collegeId
	 * @return
	 */
	@Override
	public List<SpecialtyInfo> selectByCollegeId(String collegeId) {
		// TODO Auto-generated method stub
		return specialtyInfoMapper.selectByCollegeId(collegeId);
	}
	 
}

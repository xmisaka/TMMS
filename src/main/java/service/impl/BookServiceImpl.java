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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import dao.BookInfoMapper;
import entity.BookInfo;
import exception.ExcelException;
import service.BookService;
import util.DateUtil;
import util.JxlExcelUtil;
import util.Page;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookInfoMapper bookInfoMapper;
	/**
	 * 根据输入信息条件查询书籍列表，并分页显示
	 * @param bookInfo
	 * @param page
	 * @return
	 */
	@Cacheable(value="userCache")
	@Override
	public List<BookInfo> listBook(BookInfo bookInfo, Page page) {
		int totalNumber = bookInfoMapper.countBook(bookInfo);
		page.setTotalNumber(totalNumber);
		List<BookInfo> books = bookInfoMapper.listBook(bookInfo, page);
		return books;
	}
	/**
	 * 批量导入书籍信息
	 * @param file
	 */
	@Cacheable(value="userCache")
	@Override
	public void uploadBook(File file) {
		// TODO Auto-generated method stub
		List<BookInfo> list=new ArrayList<BookInfo>();//存放每条数据的List
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkbook wbs = new HSSFWorkbook(is);//读取excel表格
			HSSFSheet childSheet = wbs.getSheetAt(0);//获取该excel中第一个sheet
			if(childSheet.getLastRowNum()>1){
				for (int i = 1; i <= childSheet.getLastRowNum(); i++) {//从1开始，排除表头
					HSSFRow row = childSheet.getRow(i);//获取第i行数据
					BookInfo bookinfo=new BookInfo();
					if(row!=null){
						Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
						bookinfo.setCreateTime(createtime);//创建时间
						bookinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
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
	                            		bookinfo.setBookName(value.substring(0,value.indexOf(".")));
	                            	}else if(j==1){//书的类型
	                            		bookinfo.setBookKind(value.substring(0,value.indexOf(".")));
	                            	}else if(j==2){//作者
	                            		bookinfo.setBookAuthor(value.substring(0,value.indexOf(".")));
	                            	}else if(j==3){//ISBN
	                            		bookinfo.setBookIsbn(value.substring(0,value.indexOf(".")));
	                            	}else if(j==4){//出版社
	                            		bookinfo.setBookPublish(value.substring(0,value.indexOf(".")));
	                            	}else if(j==5){//出版时间
	                            		bookinfo.setBookPublishTime(DateUtil.parseDate(value));
	                            	}else if(j==6){//价格
	                            		bookinfo.setBookPrice(BigDecimal.valueOf(Double.parseDouble(value.substring(0,value.indexOf(".")))));
	                            	}else if(j==7){//介绍
	                            		bookinfo.setBookIntro(value.substring(0,value.indexOf(".")));
	                            	}
	                                break;   
	                            case HSSFCell.CELL_TYPE_STRING: // 字符串
	                            	String value2 = "";
	                            		value2 = cell.getStringCellValue();
	                            		if(j==0){//书名
	                                		bookinfo.setBookName(value2);
	                                	}else if(j==1){//书的类型
	                                		bookinfo.setBookKind(value2);
	                                	}else if(j==2){//作者
	                                		bookinfo.setBookAuthor(value2);
	                                	}else if(j==3){//ISBN
	                                		bookinfo.setBookIsbn(value2);
	                                	}else if(j==4){//出版社
	                                		bookinfo.setBookPublish(value2);
	                                	}else if(j==5){//出版时间
	                                		bookinfo.setBookPublishTime(DateUtil.parseDate(value2));
	                                	}else if(j==6){//价格
	                                		bookinfo.setBookPrice(BigDecimal.valueOf(Double.parseDouble(value2)));
	                                	}else if(j==7){//介绍
	                                		bookinfo.setBookIntro(value2);
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
				    list.add(bookinfo);//list中加入一条数据
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
				bookInfoMapper.insertBookBatch(list);//批量插入数据
			}
		}
	}
	/**
	 * 批量导入书籍信息
	 * @param file
	 */
	@Override
	public void uploadBookjxl(File file){//使用jxl导入excel
		List<BookInfo> list=new ArrayList<BookInfo>();//存放每条数据的List
		try {
			InputStream in = new FileInputStream(file);
			LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
			fieldMap.put("教材书名", "bookName");
			fieldMap.put("教材类型", "bookKind");
			fieldMap.put("作者", "bookAuthor");
			fieldMap.put("书的ISBN号", "bookIsbn");
			fieldMap.put("出版社", "bookPublish");
			fieldMap.put("出版时间", "bookPublishTime");
			fieldMap.put("教材价格", "bookPrice");
			fieldMap.put("教材简介", "bookIntro");
			String uniqueFields[]={"书的ISBN号"};
			list=JxlExcelUtil.excelToList(in, "Sheet1", BookInfo.class, fieldMap, uniqueFields);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(BookInfo bookinfo:list){
			Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
			bookinfo.setCreateTime(createtime);//创建时间
			bookinfo.setUpdateTime(createtime);//更新时间(刚导入时创建时间和更新时间一致)
		}
		if(list.size()>0){
			bookInfoMapper.insertBookBatch(list);//批量插入数据
		}
	}
	/**
	 * 按条件查询书籍信息
	 * @param bookInfo
	 */
	@Cacheable(value="userCache")
	@Override
	public List<BookInfo> selectByParams(BookInfo bookInfo){
		return bookInfoMapper.selectByParams(bookInfo);
	}
	/**
	 * 批量导出书籍信息
	 * @param list
	 * @param response
	 */
	@Override
	public void exportBook(List<BookInfo> list,HttpServletResponse response) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
		fieldMap.put("bookName", "教材书名");
		fieldMap.put("bookKind", "教材类型");
		fieldMap.put("bookAuthor", "作者");
		fieldMap.put("bookIsbn", "书的ISBN号");
		fieldMap.put("bookPublish", "出版社");
		fieldMap.put("bookPublishTime", "出版时间");
		fieldMap.put("bookPrice", "教材价格");
		fieldMap.put("bookIntro", "教材简介");
		fieldMap.put("createTime", "创建时间");
		fieldMap.put("updateTime", "更新时间");
		try {
			JxlExcelUtil.listToExcel(list, fieldMap, "教材信息", response);
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加一本书籍
	 * @param bookInfo
	 */
	@Cacheable(value="userCache")
	@Override
	public int insertBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return bookInfoMapper.insertSelective(bookInfo);

	}
	/**
	 * 修改一本书籍
	 * @param bookInfo
	 */
    @Override
    public int editBook(BookInfo bookInfo) {
    	// TODO Auto-generated method stub
    	return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

	/**
	 * 删除一本书籍
	 * @param id
	 */
	@Override
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookInfoMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除书籍
	 * @param ids
	 */
	@Override
	public void deleteBooks(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			bookInfoMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	/**
	 * 根据ID获取书籍信息
	 * @param id
	 * @return
	 */
	@Override
	public BookInfo getBookByID(int id) {
		// TODO Auto-generated method stub
		return bookInfoMapper.selectByPrimaryKey(id);
	}
}

package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import util.Page;

public interface BookService {
	/**
	 * 根据输入信息条件查询书籍列表，并分页显示
	 * @param bookInfo
	 * @param page
	 * @return
	 */
	List<BookInfo> listBook(BookInfo bookInfo, Page page);
	
	/**
	 * 批量导入书籍信息
	 * @param file
	 */
	void uploadBook(File file);
	/**
	 * 批量导入书籍信息
	 * @param file
	 */
	void uploadBookjxl(File file);
	/**
	 * 按条件查询书籍信息
	 * @param bookInfo
	 */
	List<BookInfo> selectByParams(BookInfo bookInfo);
	/**
	 * 批量导出书籍信息
	 * @param list
	 * @param response
	 */
	void exportBook(List<BookInfo> list,HttpServletResponse response);
	
	/**
	 * 修改一本书籍
	 * @param bookInfo
	 */
	int editBook(BookInfo bookInfo);
	/**
	 * 添加一本书籍
	 * @param bookInfo
	 */
	int insertBook(BookInfo bookInfo);
	
	/**
	 * 删除一本书籍
	 * @param id
	 */
	int deleteBook(int id);
	
	/**
	 * 批量删除书籍
	 * @param ids
	 */
	void deleteBooks(int[] ids);
	
	/**
	 * 根据ID获取书籍信息
	 * @param id
	 * @return
	 */
	BookInfo getBookByID(int id);
}

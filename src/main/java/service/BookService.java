package service;

import java.io.File;
import java.util.List;

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
	 * 添加一本书籍
	 * @param bookInfo
	 */
	void insertBook(BookInfo bookInfo);
	
	/**
	 * 删除一本书籍
	 * @param id
	 */
	void deleteBook(int id);
	
	/**
	 * 批量删除书籍
	 * @param ids
	 */
	void deleteBooks(String[] ids);
	
	/**
	 * 根据ID获取书籍信息
	 * @param id
	 * @return
	 */
	BookInfo getBookByID(int id);
}

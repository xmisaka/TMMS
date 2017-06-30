package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.BookInfo;
import util.Page;

public interface BookInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BookInfo record);

	int insertSelective(BookInfo record);

	BookInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(BookInfo record);

	int updateByPrimaryKey(BookInfo record);

	// 下面为自定义方法
	List<BookInfo> listBook(@Param("bookInfo") BookInfo bookInfo, @Param("page") Page page);
	
	//按条件查询书籍信息
	List<BookInfo> selectByParams(@Param("bookInfo") BookInfo bookInfo);
	
	int countBook(BookInfo bookInfo);
	//批量插入书籍
	void insertBookBatch(List<BookInfo> list);
}
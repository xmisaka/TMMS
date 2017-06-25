package service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookInfoMapper;
import entity.BookInfo;
import service.BookService;
import util.Page;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookInfoMapper bookInfoMapper;
	
	@Override
	public List<BookInfo> listBook(BookInfo bookInfo, Page page) {
		int totalNumber = bookInfoMapper.countBook(bookInfo);
		page.setTotalNumber(totalNumber);
		List<BookInfo> books = bookInfoMapper.listBook(bookInfo, page);
		return books;
	}

	@Override
	public void uploadBook(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBook(BookInfo bookInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBooks(String[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public BookInfo getBookByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.BookInfo;
import service.BookService;
import util.Page;

@Controller
@RequestMapping("/book")
public class BookController {
	public static Logger logger = Logger.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;

	@RequestMapping(value="/books")
	public String listBook(Model model, @ModelAttribute BookInfo bookInfo, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(bookInfo.toString());
		List<BookInfo> books = bookService.listBook(bookInfo,page);
		model.addAttribute("books",books);
		return "bookList";
	}
}

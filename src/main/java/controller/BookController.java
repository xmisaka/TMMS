package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.BookInfo;
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
	public String listBook(Model model, @ModelAttribute BookInfo BookInfo, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(BookInfo.toString());
		List<BookInfo> books = bookService.listBook(BookInfo,page);
		model.addAttribute("books",books);
		return "book/book_list";
	}
	/**
	 * 跳转书籍信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bookadd",method=RequestMethod.GET)
	public String addbook(Model model){
		model.addAttribute(new BookInfo());
		return "book/book_add";
	}
   /**
    * 添加书籍信息
    * @param BookInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/bookadd",method=RequestMethod.POST)
	public String addbook(@Validated BookInfo BookInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "book/book_add";
    	}
    	int isOk=bookService.insertBook(BookInfo);
    	return "book/book_list";
	}
    /**
     * 跳转到批量添加书籍页面
     * @return
     */
    @RequestMapping(value="/bookaddbatch",method=RequestMethod.GET)
    public String addBookBatch(){
    	return "book/book_addbatch";
    }
    /**
     * 批量添加书籍信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/bookaddbatch",method=RequestMethod.POST)
    public String addBookBatch(String filepath){
    	filepath="F://books/books.xls";
    	File file=new File(filepath);
    	bookService.uploadBookjxl(file);
    	return "book/book_list";
    }
    /**
	 * 跳转书籍修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bookedit",method=RequestMethod.GET)
	public String editBook(Model model,int id){
		BookInfo BookInfo=bookService.getBookByID(id);
		model.addAttribute(BookInfo);
		return "book_edit";
	}
	/**
     * 导出书籍信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/bookexport",method=RequestMethod.POST)
    public String exportBooks(BookInfo BookInfo,HttpServletResponse response){
        List<BookInfo> list=bookService.selectByParams(BookInfo);
        if(list.size()>0){
        	bookService.exportBook(list, response);
        }
    	return "book/book_list";
    }
   /**
    * 修改书籍信息
    * @param BookInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/bookedit",method=RequestMethod.POST)
	public String editBook(@Validated BookInfo BookInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "book/book_edit";
    	}
    	int isOk=bookService.insertBook(BookInfo);
		return "welcome";
	}
    /**
     * 删除书籍信息
     * @param user
     * @param br
     * @return
     */
     @RequestMapping(value="/bookdel")
 	public String delbook(int id){
    	 bookService.deleteBook(id);
 		return "book/book_list";
 	}
     /**
      * 批量删除书籍信息
      * @param ids
      * @return
      */
      @RequestMapping(value="/booksdel")
  	public String delbooks(int ids[]){
    	  bookService.deleteBooks(ids);
  		return "book/book_list";
  	}
}

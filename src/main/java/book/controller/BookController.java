package book.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.User;
import service.UserService;

/**
 * 用户Controller层
 * @author Administrator
 *
 */
@Controller
public class BookController {	

    public static Logger logger = Logger.getLogger(BookController.class);
    @Autowired
    private UserService userService;
    
    @RequiresPermissions({"teacher:add"})
    @RequestMapping(value="book/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "book/book_add";
	}
   
    @RequestMapping(value="book/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br){
    	if(br.hasErrors()){
    		return "book/book_add";
    	}
    	userService.insert(user);
		return "welcome";
	}

}

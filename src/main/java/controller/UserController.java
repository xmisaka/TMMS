package controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserController {	

    public static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		//logger.info(userService.getByUserName(username).getUserName() + "+" + password);
		
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try{
			subject.login(token);
		}catch(Exception e){
		    model.addAttribute("errorMsg", "用户名/密码错误");
		    return "login";
		}
		User user = userService.getByUserName(username);
		subject.getSession().setAttribute("user", user);
		return "welcome";
	}
	

}

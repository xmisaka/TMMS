package controller;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.TmmsUser;
import service.TmmsUserService;

@Controller
public class LoginController extends LogoutFilter{
	public static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	TmmsUserService tmmsUserService;
	 @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (subject.isAuthenticated()) {  
            return "weclome";  
        }  
		//logger.info(userService.getByUserName(username).getUserName() + "+" + password);
		
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		
		try{
			subject.login(token);
		}catch(Exception e){
		    model.addAttribute("errorMsg", "用户名/密码错误");
		    return "login";
		}
		TmmsUser tmmsUser = tmmsUserService.getByUserName(username);
		subject.getSession().setAttribute("tmmsUser", tmmsUser);
		return "welcome";
	}
    /**
     * 退出登录
     * @throws Exception 
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(ServletRequest request, ServletResponse response) throws Exception {  
        Subject subject = SecurityUtils.getSubject();  
        if (subject.isAuthenticated()) {  
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
        }  
        return "redirect:login";
    }  
}

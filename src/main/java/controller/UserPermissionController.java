package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.UserPermission;
import service.UserPermissionService;
import util.DateUtil;
import util.Page;

@Controller
@RequestMapping("/userpermission")
public class UserPermissionController {
	public static Logger logger = Logger.getLogger(UserPermissionController.class);
	
	@Autowired
	UserPermissionService userPermissionService;
	
	@RequestMapping(value="/userpermissions")
	public String listUserPermission(Model model, @ModelAttribute UserPermission UserPermission, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(UserPermission.toString());
		List<UserPermission> userpermissions = userPermissionService.listUserPermission(UserPermission,page);
		model.addAttribute("userpermissions",userpermissions);
		return "userpermission/userpermission_list";
	}
	/**
	 * 跳转权限信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userpermissionadd",method=RequestMethod.GET)
	public String adduserpermission(Model model){
		model.addAttribute(new UserPermission());
		return "userpermission/userpermission_add";
	}
   /**
    * 添加权限信息
    * @param UserPermission
    * @param br
    * @return
    */
    @RequestMapping(value="/userpermissionadd",method=RequestMethod.POST)
	public String adduserpermission(Model model,@Validated UserPermission userPermission,BindingResult br){
    	if(br.hasErrors()){
    		return "userpermission/userpermission_add";
    	}
    	Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
    	userPermission.setCreateTime(createtime);
    	userPermission.setUpdateTime(createtime);
    	userPermissionService.insertUserPermission(userPermission);
    	return "redirect:userpermissions";
	}
    /**
     * 跳转到批量添加权限页面
     * @return
     */
    @RequestMapping(value="/userpermissionaddbatch",method=RequestMethod.GET)
    public String addUserPermissionBatch(){
    	return "userpermission/userpermission_addbatch";
    }
    /**
	 * 跳转权限修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}/userpermissionedit",method=RequestMethod.GET)
	public String editUserPermission(Model model,@PathVariable int id){
		UserPermission userPermission=userPermissionService.getUserPermissionByID(id);
		model.addAttribute(userPermission);
		return "userpermission/userpermission_edit";
	}
   /**
    * 修改权限信息
    * @param userPermission
    * @param br
    * @return
    */
    @RequestMapping(value="/userpermissionedit",method=RequestMethod.POST)
	public String editUserPermission(Model model,@Validated UserPermission userPermission,BindingResult br){
    	if(br.hasErrors()){
    		return "userpermission/userpermission_edit";
    	}
    	int isOk=userPermissionService.editUserPermission(userPermission);
		return "redirect:userpermissions";
	}
    /**
     * 删除权限信息
     * @param user
     * @param br
     * @return
     */
     @RequestMapping(value="/{id}/userpermissiondel")
 	public String deluserpermission(@PathVariable int id){
    	 userPermissionService.deleteUserPermission(id);
 		return "redirect:/userpermission/userpermissions";
 	}
     /**
      * 批量删除权限信息
      * @param ids
      * @return
      */
      @RequestMapping(value="/userpermissionsdel")
  	public String deluserpermissions(int ids[]){
    	  userPermissionService.deleteUserPermissions(ids);
  		return "userpermission/userpermission_list";
  	}
}

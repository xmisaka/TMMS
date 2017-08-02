package controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import entity.Menuitem;
import entity.RolePermission;
import entity.UserPermission;
import entity.UserRole;
import service.MenuitemService;
import service.RolePermissionService;
import service.UserPermissionService;
import service.UserRoleService;
import util.DateUtil;
import util.Page;

@Controller
@RequestMapping("/userrole")
public class UserRoleController {
	public static Logger logger = Logger.getLogger(UserRoleController.class);
	
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserPermissionService userPermissionService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	MenuitemService menuitemService;
	
	@RequestMapping(value="/userroles")
	public String listUserRole(Model model, @ModelAttribute UserRole UserRole, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(UserRole.toString());
		List<UserRole> userroles = userRoleService.listUserRole(UserRole,page);
		model.addAttribute("userroles",userroles);
		return "userrole/userrole_list";
	}
	/**
	 * 跳转角色信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userroleadd",method=RequestMethod.GET)
	public String adduserrole(Model model){
		model.addAttribute(new UserRole());
		return "userrole/userrole_add";
	}
   /**
    * 添加角色信息
    * @param UserRole
    * @param br
    * @return
    */
    @RequestMapping(value="/userroleadd",method=RequestMethod.POST)
	public String adduserrole(Model model,@Validated UserRole userRole,BindingResult br){
    	if(br.hasErrors()){
    		return "userrole/userrole_add";
    	}
    	Date createtime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
    	userRole.setCreateTime(createtime);
    	userRole.setUpdateTime(createtime);
    	userRoleService.insertUserRole(userRole);
    	return "redirect:userroles";
	}
    /**
     * 跳转到批量添加角色页面
     * @return
     */
    @RequestMapping(value="/userroleaddbatch",method=RequestMethod.GET)
    public String addUserRoleBatch(){
    	return "userrole/userrole_addbatch";
    }
    /**
	 * 跳转角色修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}/userroleedit",method=RequestMethod.GET)
	public String editUserRole(Model model,@PathVariable BigInteger id){
		UserRole userRole=userRoleService.getUserRoleByID(id);
		model.addAttribute(userRole);
		return "userrole/userrole_edit";
	}
   /**
    * 修改角色信息
    * @param userRole
    * @param br
    * @return
    */
    @RequestMapping(value="/userroleedit",method=RequestMethod.POST)
	public String editUserRole(Model model,@Validated UserRole userRole,BindingResult br){
    	if(br.hasErrors()){
    		return "userrole/userrole_edit";
    	}
    	userRole.setState((byte) 1);
    	int isOk=userRoleService.editUserRole(userRole);
		return "redirect:userroles";
	}
    /**
     * 删除角色信息
     * @param user
     * @param br
     * @return
     */
     @RequestMapping(value="/{id}/userroledel")
 	public String deluserrole(@PathVariable BigInteger id){
    	 userRoleService.deleteUserRole(id);
 		return "redirect:/userrole/userroles";
 	}
     /**
      * 批量删除角色信息
      * @param ids
      * @return
      */
      @RequestMapping(value="/userrolesdel")
  	public String deluserroles(BigInteger ids[]){
    	  userRoleService.deleteUserRoles(ids);
  		return "userrole/userrole_list";
  	}
      /**
       * 跳转到权限设置界面
       * @param model
       * @param id
       * @return
       */
    @RequestMapping(value="/{id}/permissionset",method=RequestMethod.GET)
    public String setpermission(Model model,@PathVariable BigInteger id){
    	List<UserPermission> userPermissions=userPermissionService.selectAll();//所有权限列表
    	List<RolePermission> rolePermissions=rolePermissionService.selectByRoleId(id);
    	for(UserPermission userPermission:userPermissions){
    		for(RolePermission rolePermission:rolePermissions){
    			if(rolePermission.getPermissionId()==userPermission.getId()){
    				userPermission.setExtend1("1");
    				break;
    			}
    		}
    	}
    	model.addAttribute("userPermissions",userPermissions);
    	model.addAttribute("rolePermissions",rolePermissions);
    	model.addAttribute("roleId", id);
    	return "/userrole/userpermissionset";
    }
    /**
     * 角色权限设置
     * @param model
     * @param id
     * @return
     */
   @RequestMapping(value="/permissionset",method=RequestMethod.POST)
   public String setpermission(HttpServletRequest request){
	    String roleId=request.getParameter("roleId");
	    long roleId1=Long.parseLong(roleId);
	    
	    String permissionIdown[]=request.getParameterValues("permissionIdown");//上一次设置的权限
	    String rolepermissionid[]=request.getParameterValues("rolepermissionid");//上一次设置的权限rolepermission表中的
	    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	    if(permissionIdown!=null&&rolepermissionid!=null){
	    	 for(int i=0;i<permissionIdown.length;i++){
	 	    	Integer permissionId1=Integer.parseInt(permissionIdown[i]);
	 	    	Integer id1=Integer.parseInt(rolepermissionid[i]);
	 	    	map.put(permissionId1, id1);
	 	    }
	    }
	    
	    Date createTime=DateUtil.parseDateTime(DateUtil.getCurrentDateTimeStr());//创建时间
	    String permissionId[]=request.getParameterValues("permissionId");
	  	for(String id:permissionId){
	  		int id1=Integer.parseInt(id);
	  		boolean iscontain=map.containsKey(id1);
	  		if(iscontain){
	  			map.remove(id1);
	  		}else{
	  			RolePermission rolePermission=new RolePermission();
	  			rolePermission.setRoleId(roleId1);
	  			rolePermission.setPermissionId(id1);
	  			rolePermission.setCreateTime(createTime);
	  			rolePermission.setUpdateTime(createTime);
	  			rolePermissionService.insertRolePermission(rolePermission);
	  		}
	  	}
	  	
	    for (Integer in : map.keySet()) {
	    	//map.keySet()返回的是所有key的值
            int upid = map.get(in);//得到每个key多对用value的值
            rolePermissionService.deleteRolePermission(upid);//上一次选中这一次没选中的删掉
        }
	  	return "redirect:/userrole/userroles";
  }
   /**
    * 跳转到菜单设置界面
    * @param model
    * @param id
    * @return
    */
  @RequestMapping(value="/{id}/menuset",method=RequestMethod.GET)
  public String setmenu(Model model,@PathVariable BigInteger id){
 	model.addAttribute("id", id);
 	return "/userrole/menuset";
  }
  /**
   * 菜单设置
   * @param model
   * @param id
   * @return
   */
 @RequestMapping(value="/menuset",method=RequestMethod.POST)
 public String setmenu(HttpServletRequest request){
	String id=request.getParameter("id");
	BigInteger roleId1=BigInteger.valueOf(Long.parseLong(id));
	String menuId[]=request.getParameterValues("menuId");
	String menuList="";
	for(String mid:menuId){
		if(!"".equals(menuList)){
			menuList+=","+mid;
		}else{
			menuList+=mid;
		}
	}
	UserRole userRole=userRoleService.getUserRoleByID(roleId1);
	if(userRole!=null){
		userRole.setExtend1(menuList);
		userRoleService.editUserRole(userRole);
	}
	return "redirect:/userrole/userroles";
 }
}

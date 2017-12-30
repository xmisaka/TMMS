package tags;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.Menuitem;
import entity.UserRole;
import service.MenuitemService;
import service.UserRoleService;

public class RoleMenuTag extends RequestContextAwareTag{
	private static final long serialVersionUID = 1L;
	private int parentId;
	private BigInteger roleid;
	MenuitemService menuitemService;
	UserRoleService userRoleService;
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	@Override
	public int doStartTagInternal() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		try{
			JspWriter out = pageContext.getOut();
			menuitemService=this.getRequestContext().getWebApplicationContext().getBean(MenuitemService.class);
			userRoleService=this.getRequestContext().getWebApplicationContext().getBean(UserRoleService.class);
			List<Menuitem> childrenmenus=menuitemService.selectByParentId(parentId);
			List<Menuitem> rolemenus=new ArrayList<Menuitem>();
			UserRole userRole=userRoleService.getUserRoleByID(roleid);
			String menuList="";
			if(userRole!=null){
				menuList=userRole.getExtend1();
				if(menuList!=null){
					for(Menuitem menu:childrenmenus){
						String menuid=menu.getId().toString();
						if(menuList.indexOf(menuid)!=-1){
							menu.setExtend2("1");
							rolemenus.add(menu);
						}
					}
				}
			}
			request.setAttribute("rolemenus", rolemenus);
			request.setAttribute("childrenmenus", childrenmenus);
		}catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	//--------------------------
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public BigInteger getRoleid() {
		return roleid;
	}
	public void setRoleid(BigInteger roleid) {
		this.roleid = roleid;
	}
	
	
}

package tags;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.Menuitem;
import service.MenuitemService;

public class MenuTag extends RequestContextAwareTag{
	private static final long serialVersionUID = 1L;
	private int parentId;
	MenuitemService menuitemService;
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	@Override
	public int doStartTagInternal() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		try{
			JspWriter out = pageContext.getOut();
			menuitemService=this.getRequestContext().getWebApplicationContext().getBean(MenuitemService.class);
			List<Menuitem> childrenmenus=menuitemService.selectByParentId(parentId);
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
	
}

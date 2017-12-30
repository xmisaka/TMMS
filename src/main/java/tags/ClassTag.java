package tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.ClassInfo;
import service.ClassService;

public class ClassTag extends RequestContextAwareTag{
	private static final long serialVersionUID = 1L;
	private String classId="";//班级Id
	static ClassService classService;
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	@Override
	public int doStartTagInternal() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		try{
			classService=this.getRequestContext().getWebApplicationContext().getBean(ClassService.class);
			JspWriter out = pageContext.getOut();
			ClassInfo classinfo=classService.getClassByID(classId);
			String className="";
			if(classinfo!=null){
				className=classinfo.getClassName();
			}
			out.print(className);
		}catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	//--------------------------
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	
}

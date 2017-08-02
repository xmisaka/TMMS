package tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.SpecialtyInfo;
import service.SpecialtyService;

public class SpecialtyTag extends RequestContextAwareTag{
	private static final long serialVersionUID = 1L;
	private String specialtyId="";//专业Id
	static SpecialtyService specialtyService;
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	@Override
	public int doStartTagInternal() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		try{
			specialtyService=this.getRequestContext().getWebApplicationContext().getBean(SpecialtyService.class);
			JspWriter out = pageContext.getOut();
			SpecialtyInfo specialtyInfo=specialtyService.getSpecialtyByID(specialtyId);
			String specialtyName="";
			if(specialtyInfo!=null){
				specialtyName=specialtyInfo.getSpecialtyName();
			}
			out.print(specialtyName);
		}catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	//--------------------------
	public String getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
	}
	
	
}

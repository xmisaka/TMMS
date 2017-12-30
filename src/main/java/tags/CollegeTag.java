package tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.CollegeInfo;
import service.CollegeService;

public class CollegeTag extends RequestContextAwareTag{
	private static final long serialVersionUID = 1L;
	private String collegeId="";//学院Id
	static CollegeService collegeService;
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	@Override
	public int doStartTagInternal() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		try{
			collegeService=this.getRequestContext().getWebApplicationContext().getBean(CollegeService.class);
			JspWriter out = pageContext.getOut();
			CollegeInfo colegeInfo=collegeService.getCollegeByID(collegeId);
			String collegeName="";
			if(colegeInfo!=null){
				collegeName=colegeInfo.getCollegeName();
			}
			out.print(collegeName);
		}catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	//--------------------------
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	
	
}

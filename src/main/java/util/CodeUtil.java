package util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.springframework.web.servlet.support.RequestContext;

import entity.CodeLibrary;
import service.CodeLibraryService;

public class CodeUtil {
	@Resource
	static CodeLibraryService codeLibraryService;
	static RequestContext requestContext;
	static PageContext pageContext;
	public static final String REQUEST_CONTEXT_PAGE_ATTRIBUTE ="org.springframework.web.servlet.tags.REQUEST_CONTEXT";
	public static String getTile(String codeno,String value){
		//HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		requestContext = (RequestContext)pageContext.getAttribute(REQUEST_CONTEXT_PAGE_ATTRIBUTE);
		codeLibraryService=requestContext.getWebApplicationContext().getBean(CodeLibraryService.class);
		List<CodeLibrary> list=codeLibraryService.selectByCodeNo(codeno);
		String itenname="";
		for(CodeLibrary code:list){
			if(code.getItemno().equals(value)){
				itenname=code.getItemname();
			}else{
				continue;
			}
		}
		return itenname;
	}
}

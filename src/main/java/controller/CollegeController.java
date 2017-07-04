package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.CollegeInfo;
import service.CollegeService;
import util.Page;

@Controller
@RequestMapping("/college")
public class CollegeController {
	public static Logger logger = Logger.getLogger(CollegeController.class);
	
	@Autowired
	CollegeService collegeService;

	@RequestMapping(value="/colleges")
	public String listCollege(Model model, @ModelAttribute CollegeInfo CollegeInfo, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(CollegeInfo.toString());
		List<CollegeInfo> colleges = collegeService.listCollege(CollegeInfo,page);
		model.addAttribute("colleges",colleges);
		return "college/college_list";
	}
	/**
	 * 跳转院系信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/collegeadd",method=RequestMethod.GET)
	public String addcollege(Model model){
		model.addAttribute(new CollegeInfo());
		return "college/college_add";
	}
   /**
    * 添加院系信息
    * @param CollegeInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/collegeadd",method=RequestMethod.POST)
	public String addcollege(@Validated CollegeInfo CollegeInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "college/college_add";
    	}
    	int isOk=collegeService.insertCollege(CollegeInfo);
    	return "college/college_list";
	}
    /**
     * 跳转到批量添加院系页面
     * @return
     */
    @RequestMapping(value="/collegeaddbatch",method=RequestMethod.GET)
    public String addCollegeBatch(){
    	return "college/college_addbatch";
    }
    /**
     * 批量添加院系信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/collegeaddbatch",method=RequestMethod.POST)
    public String addCollegeBatch(String filepath){
    	filepath="F://colleges/colleges.xls";
    	File file=new File(filepath);
    	collegeService.uploadCollegejxl(file);
    	return "college/college_list";
    }
    /**
	 * 跳转院系修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/collegeedit",method=RequestMethod.GET)
	public String editCollege(Model model,String collegeId){
		CollegeInfo CollegeInfo=collegeService.getCollegeByID(collegeId);
		model.addAttribute(CollegeInfo);
		return "college_edit";
	}
	/**
     * 导出院系信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/collegeexport",method=RequestMethod.POST)
    public String exportColleges(CollegeInfo CollegeInfo,HttpServletResponse response){
        List<CollegeInfo> list=collegeService.selectByParams(CollegeInfo);
        if(list.size()>0){
        	collegeService.exportCollege(list, response);
        }
    	return "college/college_list";
    }
   /**
    * 修改院系信息
    * @param CollegeInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/collegeedit",method=RequestMethod.POST)
	public String editCollege(@Validated CollegeInfo CollegeInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "college/college_edit";
    	}
    	int isOk=collegeService.insertCollege(CollegeInfo);
		return "welcome";
	}
    /**
     * 删除院系信息
     * @param collegeId
     * @return
     */
     @RequestMapping(value="/collegedel")
 	public String delcollege(String collegeId){
    	 collegeService.deleteCollege(collegeId);
 		return "college/college_list";
 	}
     /**
      * 批量删除院系信息
      * @param collegeIds
      * @return
      */
      @RequestMapping(value="/collegesdel")
  	public String delcolleges(String collegeIds[]){
    	  collegeService.deleteColleges(collegeIds);
  		return "college/college_list";
  	}
}

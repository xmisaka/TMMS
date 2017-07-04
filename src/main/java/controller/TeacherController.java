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

import entity.TeacherInfo;
import service.TeacherService;
import util.Page;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	public static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	TeacherService teacherService;

	@RequestMapping(value="/teachers")
	public String listTeacher(Model model, @ModelAttribute TeacherInfo TeacherInfo, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		logger.info(TeacherInfo.toString());
		List<TeacherInfo> teachers = teacherService.listTeacher(TeacherInfo,page);
		model.addAttribute("teachers",teachers);
		return "teacher/teacher_list";
	}
	/**
	 * 跳转教师信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/teacheradd",method=RequestMethod.GET)
	public String addteacher(Model model){
		model.addAttribute(new TeacherInfo());
		return "teacher/teacher_add";
	}
   /**
    * 添加教师信息
    * @param TeacherInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/teacheradd",method=RequestMethod.POST)
	public String addteacher(@Validated TeacherInfo TeacherInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "teacher/teacher_add";
    	}
    	int isOk=teacherService.insertTeacher(TeacherInfo);
    	return "teacher/teacher_list";
	}
    /**
     * 跳转到批量添加教师页面
     * @return
     */
    @RequestMapping(value="/teacheraddbatch",method=RequestMethod.GET)
    public String addTeacherBatch(){
    	return "teacher/teacher_addbatch";
    }
    /**
     * 批量添加教师信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/teacheraddbatch",method=RequestMethod.POST)
    public String addTeacherBatch(String filepath){
    	filepath="F://teachers/teachers.xls";
    	File file=new File(filepath);
    	teacherService.uploadTeacherjxl(file);
    	return "teacher/teacher_list";
    }
    /**
	 * 跳转教师修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/teacheredit",method=RequestMethod.GET)
	public String editTeacher(Model model,int id){
		TeacherInfo TeacherInfo=teacherService.getTeacherByID(id);
		model.addAttribute(TeacherInfo);
		return "teacher_edit";
	}
	/**
     * 导出教师信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/teacherexport",method=RequestMethod.POST)
    public String exportTeachers(TeacherInfo TeacherInfo,HttpServletResponse response){
        List<TeacherInfo> list=teacherService.selectByParams(TeacherInfo);
        if(list.size()>0){
        	teacherService.exportTeacher(list, response);
        }
    	return "teacher/teacher_list";
    }
   /**
    * 修改教师信息
    * @param TeacherInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/teacheredit",method=RequestMethod.POST)
	public String editTeacher(@Validated TeacherInfo TeacherInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "teacher/teacher_edit";
    	}
    	int isOk=teacherService.insertTeacher(TeacherInfo);
		return "welcome";
	}
    /**
     * 删除教师信息
     * @param id
     * @return
     */
     @RequestMapping(value="/teacherdel")
 	public String delteacher(int id){
    	 teacherService.deleteTeacher(id);
 		return "teacher/teacher_list";
 	}
     /**
      * 批量删除教师信息
      * @param ids
      * @return
      */
      @RequestMapping(value="/teachersdel")
  	public String delteachers(int ids[]){
    	  teacherService.deleteTeachers(ids);
  		return "teacher/teacher_list";
  	}
}

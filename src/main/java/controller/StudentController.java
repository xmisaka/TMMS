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

import entity.StudentInfo;
import service.StudentService;
import util.Page;

@Controller
@RequestMapping("/stu")
public class StudentController {
	public static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	/**
	 * 学生列表分页查询
	 * @param model
	 * @param bookInfo
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/students")
	public String listStudent(Model model, @ModelAttribute StudentInfo studentInfo, @ModelAttribute Page page, HttpServletRequest request) {
		
		String currentPageStr = request.getParameter("currentPage");
		logger.info(currentPageStr + "===========");
		if(currentPageStr != null){
			int currentPage = Integer.parseInt(currentPageStr);
			page.setCurrentPage(currentPage);
		}
		logger.info(page.toString());
		List<StudentInfo> students = studentService.listStudent(studentInfo, page);
		model.addAttribute("students",students);
		return "student/student_list";
	}
	/**
	 * 跳转学生信息添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/studentadd",method=RequestMethod.GET)
	public String addStudent(Model model){
		model.addAttribute(new StudentInfo());
		return "student/student_add";
	}
   /**
    * 添加学生信息
    * @param studentInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/studentadd",method=RequestMethod.POST)
	public String addStudent(@Validated StudentInfo studentInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "student/student_add";
    	}
    	int isOk=studentService.insertStudent(studentInfo);
    	return "student/student_list";
	}
    /**
     * 跳转到批量添加学生页面
     * @return
     */
    @RequestMapping(value="/studentaddbatch",method=RequestMethod.GET)
    public String addBookBatch(){
    	return "student/student_addbatch";
    }
    /**
     * 批量添加学生信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/studentaddbatch",method=RequestMethod.POST)
    public String addBookBatch(String filepath){
    	File file=new File(filepath);
    	studentService.uploadStudentjxl(file);
    	return "student/student_list";
    }
    /**
	 * 跳转学生修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/studentedit",method=RequestMethod.GET)
	public String editBook(Model model,int id){
		StudentInfo studentInfo=studentService.getStudentByID(id);
		model.addAttribute(studentInfo);
		return "student_edit";
	}
	/**
     * 导出学生信息
     * @param filepath
     * @return
     */
    @RequestMapping(value="/studentexport",method=RequestMethod.POST)
    public String exportBooks(StudentInfo studentInfo,HttpServletResponse response){
        List<StudentInfo> list=studentService.selectByParams(studentInfo);
        if(list.size()>0){
        	studentService.exportStudent(list, response);
        }
    	return "student/student_list";
    }
   /**
    * 修改学生信息
    * @param studentInfo
    * @param br
    * @return
    */
    @RequestMapping(value="/studentedit",method=RequestMethod.POST)
	public String editBook(@Validated StudentInfo studentInfo,BindingResult br){
    	if(br.hasErrors()){
    		return "student/student_edit";
    	}
    	int isOk=studentService.insertStudent(studentInfo);
		return "welcome";
	}
    /**
     * 删除学生信息
     * @param user
     * @param br
     * @return
     */
     @RequestMapping(value="/studentdel")
 	public String delStudent(int id){
    	 studentService.deleteStudent(id);
 		return "student/student_list";
 	}
     /**
      * 批量删除学生信息
      * @param ids
      * @return
      */
      @RequestMapping(value="/studentsdel")
  	public String delStudents(int ids[]){
    	  studentService.deleteStudents(ids);
  		return "student/student_list";
  	}
}

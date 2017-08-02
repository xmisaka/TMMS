package entity;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassInfo {
    private String classId;

    private String className;

    private String classPwd;

    private String collegeId;

    private String specialtyId;

    private String grade;

    private String monitorNo;

    private String monitorName;

    private String monitorLinkinfo;

    private Integer studentNum;

    private Integer paidStudentNum;

    private Date createTime;

    private Date updateTime;

    private String extend1;

    private String extend2;

    private String extend3;
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
    @NotEmpty(message="班级名不能为空")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassPwd() {
        return classPwd;
    }

    public void setClassPwd(String classPwd) {
        this.classPwd = classPwd == null ? null : classPwd.trim();
    }
    @NotEmpty(message="所属学院不能为空")
    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }
    @NotEmpty(message="所属专业不能为空")
    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId == null ? null : specialtyId.trim();
    }
    @NotEmpty(message="年级不能为空")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
  
    public String getMonitorNo() {
        return monitorNo;
    }

    public void setMonitorNo(String monitorNo) {
        this.monitorNo = monitorNo == null ? null : monitorNo.trim();
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName == null ? null : monitorName.trim();
    }

    public String getMonitorLinkinfo() {
        return monitorLinkinfo;
    }

    public void setMonitorLinkinfo(String monitorLinkinfo) {
        this.monitorLinkinfo = monitorLinkinfo == null ? null : monitorLinkinfo.trim();
    }
    @NotNull(message="学生数量不能为空")
    @DecimalMin("0")
    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }
    @NotNull(message="已缴费学生数量不能为空")
    public Integer getPaidStudentNum() {
        return paidStudentNum;
    }

    
    public void setPaidStudentNum(Integer paidStudentNum) {
        this.paidStudentNum = paidStudentNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }
}
package entity;

import java.util.Date;

public class CollegeInfo {
    private String collegeId;

    private String collegeName;

    private String collegePwd;

    private String collegePrincipal;

    private String school;

    private Date createTime;

    private Date updateTime;

    private String extend1;

    private String extend2;

    private String extend3;

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getCollegePwd() {
        return collegePwd;
    }

    public void setCollegePwd(String collegePwd) {
        this.collegePwd = collegePwd == null ? null : collegePwd.trim();
    }

    public String getCollegePrincipal() {
        return collegePrincipal;
    }

    public void setCollegePrincipal(String collegePrincipal) {
        this.collegePrincipal = collegePrincipal == null ? null : collegePrincipal.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
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
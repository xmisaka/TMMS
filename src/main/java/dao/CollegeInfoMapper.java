package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.CollegeInfo;
import util.Page;

public interface CollegeInfoMapper {
    int deleteByPrimaryKey(String collegeId);

    int insert(CollegeInfo record);

    int insertSelective(CollegeInfo record);

    CollegeInfo selectByPrimaryKey(String collegeId);

    int updateByPrimaryKeySelective(CollegeInfo record);

    int updateByPrimaryKey(CollegeInfo record);
    // 下面为自定义方法
 	List<CollegeInfo> listCollege(@Param("collegeInfo") CollegeInfo collegeInfo, @Param("page") Page page);
 	//按条件查询院系信息
    List<CollegeInfo> selectByParams(@Param("collegeInfo") CollegeInfo collegeInfo);
    
 	int countCollege(CollegeInfo collegeInfo);
 	//批量插入院系信息
 	void insertCollegeBatch(List<CollegeInfo> list);
 	//查询全部
 	List<CollegeInfo> selectAll();
}
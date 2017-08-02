package dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import entity.TmmsUser;
import util.Page;

public interface TmmsUserMapper {
    public TmmsUser getByUserName(String userName);
	
	public Set<String> getRoles(String userName);
	
	public Set<String> getPermissions(String userName);
	
    int deleteByPrimaryKey(Integer id);

    int insert(TmmsUser record);

    int insertSelective(TmmsUser record);

    TmmsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmmsUser record);

    int updateByPrimaryKey(TmmsUser record);
 // 下面为自定义方法
 	List<TmmsUser> listTmmsUser(@Param("tmmsUser") TmmsUser tmmsUser, @Param("page") Page page);
 	
 	//按条件查询书籍信息
 	List<TmmsUser> selectByParams(@Param("tmmsUser") TmmsUser tmmsUser);
 	
 	int countTmmsUser(TmmsUser tmmsUser);
 	//批量插入书籍
 	void insertTmmsUserBatch(List<TmmsUser> list);
}
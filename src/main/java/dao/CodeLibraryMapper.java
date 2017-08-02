package dao;

import java.util.List;

import entity.CodeLibrary;

public interface CodeLibraryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CodeLibrary record);

    int insertSelective(CodeLibrary record);

    CodeLibrary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CodeLibrary record);

    int updateByPrimaryKey(CodeLibrary record);
    
    List<CodeLibrary> selectByCodeNo(String codeno);
}
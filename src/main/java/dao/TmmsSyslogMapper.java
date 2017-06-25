package dao;

import entity.TmmsSyslog;
import entity.TmmsSyslogWithBLOBs;

public interface TmmsSyslogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmmsSyslogWithBLOBs record);

    int insertSelective(TmmsSyslogWithBLOBs record);

    TmmsSyslogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmmsSyslogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TmmsSyslogWithBLOBs record);

    int updateByPrimaryKey(TmmsSyslog record);
}
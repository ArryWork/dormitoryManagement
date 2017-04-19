package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.OutEntryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OutEntryRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OutEntryRecord record);

    int insertSelective(OutEntryRecord record);

    OutEntryRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OutEntryRecord record);

    int updateByPrimaryKey(OutEntryRecord record);

    List<OutEntryRecord> getOutEntryRecord(@Param("start") Date start, @Param("end") Date end);
}
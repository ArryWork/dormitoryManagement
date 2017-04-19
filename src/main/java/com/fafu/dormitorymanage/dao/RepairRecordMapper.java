package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.RepairRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepairRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepairRecord record);

    int insertSelective(RepairRecord record);

    RepairRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepairRecord record);

    int updateByPrimaryKey(RepairRecord record);

    List<RepairRecord> getRepairRecords(@Param("start") Date start, @Param("end") Date end , @Param("dormitoryId") Integer dormitoryId);

    int solve(@Param("recordId") Integer recordId);
//    List<RepairRecord> getRepairRecords();

}
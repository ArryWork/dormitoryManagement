package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.RepairRecord;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-07.
 */
public interface RepairRecordService {
    List<RepairRecord> getRepairRecord(String startTime,String endTime,Integer dormitoryId) throws ParseException;

    Map<String,Object> addRepairRecord(RepairRecord repairRecord);

    Map<String,Object> solve(Integer recordId);
}

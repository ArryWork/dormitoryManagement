package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.OutEntryRecord;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-10.
 */
public interface OutEntryRecordSerivice {

    List<OutEntryRecord> getOutEntryRecord(String startTime,String endTime) throws ParseException;

    Map<String,Object> addOutEntryRecord(OutEntryRecord outEntryRecord);
}

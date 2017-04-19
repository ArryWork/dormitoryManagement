package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.OutEntryRecordMapper;
import com.fafu.dormitorymanage.pojo.OutEntryRecord;
import com.fafu.dormitorymanage.service.OutEntryRecordSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-10.
 */
@Service
public class OutEntryRecordServiceImpl implements OutEntryRecordSerivice {
    @Autowired
    private OutEntryRecordMapper outEntryRecordMapper;

    @Override
    public List<OutEntryRecord> getOutEntryRecord(String startTime,String endTime) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        if(startTime!=null&&!"".equals(startTime)) {
            start = fmt.parse(startTime);
        }
        if(endTime != null&&!"".equals(endTime)) {
            end = fmt.parse(endTime);
        }
        return outEntryRecordMapper.getOutEntryRecord(start,end);
    }

    @Override
    public Map<String, Object> addOutEntryRecord(OutEntryRecord outEntryRecord) {
        Map<String,Object> result = new HashMap<>();
        outEntryRecord.setTime(new Date());
        int i = outEntryRecordMapper.insert(outEntryRecord);
        if(i==1)
            result.put("msg","成功");
        else
            result.put("fail","失败");
        return result;
    }
}

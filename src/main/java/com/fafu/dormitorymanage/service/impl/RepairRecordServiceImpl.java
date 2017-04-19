package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.RepairRecordMapper;
import com.fafu.dormitorymanage.pojo.RepairRecord;
import com.fafu.dormitorymanage.service.RepairRecordService;
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
 * Created by 林强 on 2017-04-07.
 */
@Service
public class RepairRecordServiceImpl implements RepairRecordService {
    @Autowired
    RepairRecordMapper repairRecordMapper;

    @Override
    public List<RepairRecord> getRepairRecord(String startTime,String endTime,Integer dormitoryId) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        if(startTime!=null&&!"".equals(startTime)) {
            start = fmt.parse(startTime);
        }
        if(endTime != null&&!"".equals(endTime)) {
            end = fmt.parse(endTime);
        }
      return  repairRecordMapper.getRepairRecords(start,end,dormitoryId);
//        return  repairRecordMapper.getRepairRecords();

    }

    @Override
    public Map<String, Object> addRepairRecord(RepairRecord repairRecord) {
        Map<String,Object> result = new HashMap<>();
        repairRecord.setReportTime(new Date());
        int i = repairRecordMapper.insert(repairRecord);
        if(i==1)
            result.put("msg","成功");
        else
            result.put("fail","失败");
        return result;
    }

    @Override
    public Map<String, Object> solve(Integer recordId) {
        Map<String,Object> result = new HashMap<>();
        int i = repairRecordMapper.solve(recordId);
        if(i==1)
            result.put("msg","成功");
        else
            result.put("fail","失败");
        return result;
    }
}

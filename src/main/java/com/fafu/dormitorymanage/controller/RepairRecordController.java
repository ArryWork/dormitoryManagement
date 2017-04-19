package com.fafu.dormitorymanage.controller;

import com.fafu.dormitorymanage.pojo.RepairRecord;
import com.fafu.dormitorymanage.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-07.
 */
@Controller
@RequestMapping("repairRecord")
public class RepairRecordController {
    @Autowired
    RepairRecordService repairRecordService;

    @RequestMapping("repairRecordPage")
    public String repairRecordPage(){
        return "repairRecord/repairRecord";
    }

    @RequestMapping("getRepairRecord")
    @ResponseBody
    public List<RepairRecord> getRepairRecord(String startTime,String endTime,Integer dormitoryId) throws ParseException {
        return  repairRecordService.getRepairRecord(startTime,endTime,dormitoryId);
    }

    @RequestMapping("addRepairRecord")
    @ResponseBody
    public Map<String,Object> addRepairRecord(RepairRecord repairRecord){
        return repairRecordService.addRepairRecord(repairRecord);
    }

    @RequestMapping("solve")
    @ResponseBody
    public Map<String,Object> solve(Integer recordId){
        return repairRecordService.solve(recordId);
    }
}

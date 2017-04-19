package com.fafu.dormitorymanage.controller;

import com.fafu.dormitorymanage.pojo.OutEntryRecord;
import com.fafu.dormitorymanage.service.OutEntryRecordSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-06.
 */
@Controller
@RequestMapping("outEntryRecord")
public class OutEntryRecordController {
    @Autowired
    private OutEntryRecordSerivice outEntryRecordSerivice;

    @RequestMapping("outEntryRecordPage")
    public String outEntryRecord(){
        return "outEntryRecord/outEntryRecord";
    }

    @RequestMapping("getOutEntryRecord")
    @ResponseBody
    public List<OutEntryRecord> getOutEntryRecord(String startTime,String endTime) throws ParseException {
        return outEntryRecordSerivice.getOutEntryRecord(startTime,endTime);
    }
    @RequestMapping("addOutEntryRecord")
    @ResponseBody
    public Map<String,Object> addOutEntryRecord(OutEntryRecord outEntryRecord){
        return outEntryRecordSerivice.addOutEntryRecord(outEntryRecord);
    }

}

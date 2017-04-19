package com.fafu.dormitorymanage.controller;

import com.fafu.dormitorymanage.pojo.Visitor;
import com.fafu.dormitorymanage.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-06.
 */
@RequestMapping("visitor")
@Controller
public class VisitorController {
    @Autowired
    public VisitorService visitorService;

    @RequestMapping("visitorManage")
    public String visitorManage(){
        return "visitor/visitorManage";
    }
    @RequestMapping("getAllVisitor")
    @ResponseBody
    public List<Visitor> getAllVisitor(){
        return visitorService.getAllVisitor();
    }

    @RequestMapping("addVisitRecord")
    @ResponseBody
    public Map<String,Object> addVisitRecord(Visitor visitor){
        return  visitorService.addVisitRecord(visitor);
    }

    @RequestMapping("endVisit")
    @ResponseBody
    public Map<String,Object> endVisit(String visitId){
        return visitorService.endVisit(visitId);
    }
}

package com.fafu.dormitorymanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fafu.dormitorymanage.pojo.Manager;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.ManagerService;
import com.fafu.dormitorymanage.service.StudentService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by 林强 on 2017-03-31.
 */
@Controller
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("login.do")
    @ResponseBody
    public Map userLogin(HttpSession session, Manager manager){
        Map result  = new HashMap();
        try {
            Manager m = managerService.login(manager);
            if(m!=null) {
                session.setAttribute("manager",m);
                result.put("url","manager/goHome.do");
            }else {
                result.put("error","账号不存在或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("goHome.do")
    public String goHome(){
        return "manager/main";
    }

    @RequestMapping("inputDatePage.do")
    public String inputDatePage(){
        return "manager/inputDataPage";
    }
    @RequestMapping("checkNewStudent")
    @ResponseBody
    public List<Student> checkNewStudent(@RequestParam MultipartFile file){
        List<Student> students = managerService.getStudentList(file);
        Map dormitoryMap = managerService.getDomitoryId();
        List snoList = studentService.getSnos();
        students.forEach(student -> {
            if(snoList.contains(student.getStudentNo()))
                student.setFlag(1);
            else
                student.setFlag(0);
            if(student.getName()==null||"".equals(student.getName()))
                return;
            student.setDormitoryId(Integer.valueOf(dormitoryMap.get(student.getDormitoryName()).toString()));
        });
        return students;
    }

    @RequestMapping("inputStudent")
    @ResponseBody
    public Map inputStudents(String studentsJson){
        Map result = new HashMap();
        List<Student> students=JSON.parseArray(studentsJson,Student.class);
        List<Student> failStudents = students.stream()
                .filter(student -> student.getFlag() == 1)
                .collect(Collectors.toList());
        students = students.stream()
                .filter(student -> student.getFlag() == 0)
                .collect(Collectors.toList());
        int t = 0;
        if(students.size()!=0)
            t = managerService.addNewStudent(students);
        result.put("successCount",t);
        result.put("failStudent",failStudents);
        return result;
    }
}

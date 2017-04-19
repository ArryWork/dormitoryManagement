package com.fafu.dormitorymanage.controller;

import com.alibaba.fastjson.JSON;
import com.fafu.dormitorymanage.pojo.Manager;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.ManagerService;
import com.fafu.dormitorymanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by 林强 on 2017-03-31.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @RequestMapping("getAllStudent.do")
    @ResponseBody
    public List<Student> getAllStudent(Student student){
        List<Student> students = studentService.getAllStudent(student);
        return students;
    }
    @RequestMapping("studentManage")
    public String studentManage(){
        return "student/studentManage";
    }

    @RequestMapping("modifyStudent")
    @ResponseBody
    public Map<String,Object> modifyStudent (Student student){
        Map<String,Object> result = new HashMap<>();
        if(studentService.modifyStudent(student)==1){
            result.put("msg",student.getName()+"的信息修改成功");
        }else {
            result.put("fail", "修改失败");
        }
        return result;
    }

    @RequestMapping("addStudent")
    @ResponseBody
    public Map<String,Object> addStudent (Student student){
        Map<String,Object> result;
        result = studentService.addStudent(student);
        return result;
    }
    @RequestMapping("getStudentByNo")
    @ResponseBody
    public Student getStudentByNo(String studentNo){
        return  studentService.getStudentByNo(studentNo);
    }
}

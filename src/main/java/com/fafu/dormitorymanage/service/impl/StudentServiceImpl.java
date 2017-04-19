package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.StudentMapper;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-01.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> getAllStudent(Student student) {
        return  studentMapper.getAllStudent(student);
    }

    @Override
    public List getSnos() {
        return  studentMapper.getSnos();
    }

    @Override
    public int modifyStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public Map<String,Object> addStudent(Student student) {
        Map<String,Object> result = new HashMap<>();
        List<String> s = getSnos();
        if(s.contains(student.getStudentNo())){
            result.put("fail","学号重复");
        }else {
            studentMapper.insert(student);
        }
        return result;
    }

    @Override
    public Student getStudentByNo(String studentNo) {
        return studentMapper.getStudentByNo(studentNo);
    }
}

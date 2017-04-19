package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-01.
 */
public interface StudentService {
    List<Student> getAllStudent(Student student);

    List getSnos();

    int modifyStudent(Student student);

    Map<String,Object> addStudent(Student student);

    Student getStudentByNo(String studentNo);
}

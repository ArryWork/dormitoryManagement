package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.Manager;
import com.fafu.dormitorymanage.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-03-31.
 */
public interface ManagerService {

    public Manager login(Manager manager) throws Exception;

    List<Student> getStudentList(MultipartFile file);

    Map getDomitoryId();

    int addNewStudent(List<Student> students);
}

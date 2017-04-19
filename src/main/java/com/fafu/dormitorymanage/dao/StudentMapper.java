package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int addNewStudent(@Param("students") List<Student> students);

    List<Student> getAllStudent(Student student);

    List getSnos();

    List<Student> getStudentsByRoomId(@Param("dormitoryId")String dormitoryId,@Param("roomOrd") String roomOrd);

    int updateHead(@Param("roomHeadId") String roomHeadId, @Param("roomId") String roomId) throws Exception;

    Student getStudentByNo(@Param("studentNo") String studentNo);
}
package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> getAllVisitor();

    int setVisitStatus(@Param("visitId") String visitId, @Param("status") int status);
}
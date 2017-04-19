package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.Dormitory;

import java.util.List;
import java.util.Map;

public interface DormitoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    Dormitory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);

    List<Map> getIdNameMap();

    List<Dormitory> getDormitory();
}
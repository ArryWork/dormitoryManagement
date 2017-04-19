package com.fafu.dormitorymanage.dao;

import com.fafu.dormitorymanage.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> getRoomList(@Param("dormitoryId") String dormitoryId);

    int setHead(@Param("roomHeadId") String roomHeadId, @Param("roomId") String roomId) throws Exception;

    List<Room> getRoomFromStudent();
}
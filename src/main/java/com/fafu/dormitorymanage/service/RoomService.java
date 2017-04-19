package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.Room;
import com.fafu.dormitorymanage.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-01.
 */
public interface RoomService {

    List<Room> getRooms(String dormitoryId);

    List<Student> getMembers(String dormitoryId,String roomOrd);

    int setRoomHead(String roomHeadId, String roomId) throws Exception;

    List<Room> getRoomsFromStudent();
}

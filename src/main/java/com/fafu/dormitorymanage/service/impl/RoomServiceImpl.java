package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.RoomMapper;
import com.fafu.dormitorymanage.dao.StudentMapper;
import com.fafu.dormitorymanage.pojo.Room;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-05.
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Room> getRooms(String dormitoryId) {
        List<Room> rooms = roomMapper.getRoomList(dormitoryId);
        return rooms;
    }

    @Override
    public List<Student> getMembers(String dormitoryId,String roomOrd) {
        return  studentMapper.getStudentsByRoomId(dormitoryId,roomOrd);
    }

    @Override
    @Transactional
    public int setRoomHead(String roomHeadId, String roomId) throws Exception{
        int t1 = roomMapper.setHead(roomHeadId,roomId);
        int t2 = studentMapper.updateHead(roomHeadId,roomId);
        return t1;
    }

    @Override
    public List<Room> getRoomsFromStudent() {
        return roomMapper.getRoomFromStudent();
    }
}

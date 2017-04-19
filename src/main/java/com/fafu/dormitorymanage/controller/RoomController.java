package com.fafu.dormitorymanage.controller;

import com.fafu.dormitorymanage.pojo.Room;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.RoomService;
import com.fafu.dormitorymanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-03-31.
 */
@Controller
@RequestMapping("room")
public class RoomController {
    @Autowired
    public RoomService roomService;
    @RequestMapping("roomManage")
    public String studentManage(){
        return "room/roomManage";
    }

    @RequestMapping("getRoom")
    @ResponseBody
    public List<Room> getRoom(String dormitoryId){
        List<Room> rooms = roomService.getRooms(dormitoryId);
        return rooms;
    }
    @RequestMapping("getMembersByRoom")
    @ResponseBody
    public List<Student> getMembers(String dormitoryId, String roomOrd){
        List<Student> students = roomService.getMembers(dormitoryId,roomOrd);
        return students;
    }
    @RequestMapping("setHead")
    @ResponseBody
    public Map<String,Object> setHead(String roomHeadId, String roomId){
        Map<String,Object> result = new HashMap<>();
        try {
            if(roomService.setRoomHead(roomHeadId,roomId)==1){
                result.put("msg","成功");
            }else
                result.put("msg","更改舍长设置失败，请重试");
        } catch (Exception e) {
            result.put("error",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    public void updateRoom(){
        List<Room> rooms = roomService.getRoomsFromStudent();
    }
}

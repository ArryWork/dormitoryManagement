package com.fafu.dormitorymanage.pojo;

public class Room {
    private Integer id;

    private Integer dormitoryId;

    private Integer headId;

    private Integer roomOrd;

    private String dormitory;

    private String head;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public Integer getRoomOrd() {
        return roomOrd;
    }

    public void setRoomOrd(Integer roomOrd) {
        this.roomOrd = roomOrd;
    }
}
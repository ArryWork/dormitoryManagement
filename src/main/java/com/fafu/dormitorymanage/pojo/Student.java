package com.fafu.dormitorymanage.pojo;

public class Student {
    private Integer id;

    private Integer dormitoryId;

    private Integer roomOrd;

    private String name;

    private String isHead;

    private String studentNo;

    private String major;

    private int grade;

    private int classNo;

    private String dormitoryName;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getRoomOrd() {
        return roomOrd;
    }

    public void setRoomOrd(Integer roomOrd) {
        this.roomOrd = roomOrd;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public Student(){}
    public Student( Integer room_ord, String name, String is_head, String student_no, String major, int grade, int class_no, String dormitoryName) {
        this.roomOrd = room_ord;
        this.name = name;
        this.isHead = is_head;
        this.studentNo = student_no;
        this.major = major;
        this.grade = grade;
        this.classNo = class_no;
        this.dormitoryName = dormitoryName;
    }
}
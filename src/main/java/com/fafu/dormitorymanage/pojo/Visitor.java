package com.fafu.dormitorymanage.pojo;

import java.util.Date;

public class Visitor {
    private Integer id;

    private String name;

    private String relation;

    private String idCardNo;

    private Integer visitStatus;

    private String visitReason;

    private Date visitDate;

    private int visitDormitoryId;

    private int visitRoomOrd;
    private int visitStudentId;

    private String student;
    private String dormitory;

    public String getStudent() {
        return student;
    }

    public int getVisitRoomOrd() {
        return visitRoomOrd;
    }

    public void setVisitRoomOrd(int visitRoomOrd) {
        this.visitRoomOrd = visitRoomOrd;
    }

    public int getVisitDormitoryId() {

        return visitDormitoryId;
    }

    public void setVisitDormitoryId(int visitDormitoryId) {
        this.visitDormitoryId = visitDormitoryId;
    }

    public void setStudent(String student) {
        this.student = student;
    }


    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public int getVisitStudentId() {
        return visitStudentId;
    }

    public void setVisitStudentId(int visitStudentId) {
        this.visitStudentId = visitStudentId;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Integer getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(Integer visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
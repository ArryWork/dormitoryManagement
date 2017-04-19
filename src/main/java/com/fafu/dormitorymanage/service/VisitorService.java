package com.fafu.dormitorymanage.service;

import com.fafu.dormitorymanage.pojo.Visitor;

import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-06.
 */
public interface VisitorService {
     List<Visitor> getAllVisitor();

    Map<String,Object> addVisitRecord(Visitor visitor);

    Map<String,Object> endVisit(String visitId);
}

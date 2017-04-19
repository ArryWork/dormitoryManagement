package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.VisitorMapper;
import com.fafu.dormitorymanage.pojo.Visitor;
import com.fafu.dormitorymanage.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林强 on 2017-04-06.
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    @Override
    public List<Visitor> getAllVisitor() {
        return visitorMapper.getAllVisitor();
    }

    @Override
    public Map<String,Object> addVisitRecord(Visitor visitor) {
        Map<String, Object> result = new HashMap<>();
        visitor.setVisitDate(new Date());
        visitor.setVisitStatus(1);
         if(visitorMapper.insert(visitor)==1)
             result.put("msg","成功");
         else
             result.put("fail","失败");
        return result;

    }

    @Override
    public Map<String, Object> endVisit(String visitId) {
        Map<String, Object> result = new HashMap<>();
        int t = visitorMapper.setVisitStatus(visitId,0);
        if(t==1)
            result.put("msg","成功");
        else
            result.put("fail","失败");
        return result;
    }
}

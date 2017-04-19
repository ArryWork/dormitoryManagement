package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.DormitoryMapper;
import com.fafu.dormitorymanage.pojo.Dormitory;
import com.fafu.dormitorymanage.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 林强 on 2017-04-06.
 */
@Service
public class PubServiceImpl implements PubService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Override
    public List<Dormitory> getDormitory() {
        List<Dormitory> dormitories = dormitoryMapper.getDormitory();
        return  dormitories;
    }
}

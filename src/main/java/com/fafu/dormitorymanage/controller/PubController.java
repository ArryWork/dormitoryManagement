package com.fafu.dormitorymanage.controller;

import com.fafu.dormitorymanage.pojo.Dormitory;
import com.fafu.dormitorymanage.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 林强 on 2017-04-06.
 */
@Controller
@RequestMapping("pub")
public class PubController {
    @Autowired
    public PubService pubService;


    @RequestMapping("getDormitory")
    @ResponseBody
    public List<Dormitory> getDomitory(){
       return pubService.getDormitory();
    }
}

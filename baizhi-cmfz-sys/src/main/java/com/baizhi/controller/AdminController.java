package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Decide;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/13.
 */
@Controller
/*命名空间*/
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /*把返回值转成json类型*/
    @ResponseBody
    @RequestMapping("/selectByName")
    public Decide selectByName(Admin admin){
        Admin dbadmin = adminService.selectByName(admin);
        Decide decide = new Decide();
        if (dbadmin!=null){
            decide.setName(true);
            return decide;
        }else {
            decide.setName(false);
            return decide;
        }
    }
}

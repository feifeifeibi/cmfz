package com.baizhi.test;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class adminT {


    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testselectAdmin(){
        Admin huxz = adminService.selectByName(new Admin(null, "kaka", "123456", null));
        System.out.println(huxz);
    }

    @Test
    public void testAddAdmin(){

        adminService.addAdmin(new Admin(null, "kaka", "123456", null));
        //adminMapper.insert(new Admin("2", "xiaohu", "123456", "qwe"));
    }

}

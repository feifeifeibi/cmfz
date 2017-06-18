package com.baizhi.test;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class MenuT {
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void testSelectAll(){
        List<Menu> menus = menuService.selectAll();
        System.out.println(menus);
    }
}

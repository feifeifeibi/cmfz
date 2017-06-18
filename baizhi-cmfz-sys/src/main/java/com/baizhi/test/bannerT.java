package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")

public class bannerT {
    @Autowired
    private BannerService bannerService;

    @Test
    public void testSelectAll(){
        List<Banner> banners = bannerService.selectAll();
        System.out.println(banners);
    }

    @Test
    public void testInsert(){
        bannerService.insert(new Banner("2","lisi","6213","1"));
    }

   /* @Test
    public void testUpdate(){

    }*/
}

package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")

public class albumT {
    @Autowired
    private AlbumService albumService;
    @Test
    public void testSelectAll(){
        List<Album> albumList = albumService.selectAll();
        System.out.println(albumList);
    }

    @Test
    public void testAdd(){
        /*id, thumbnail, title, score, author, broadcast, createDate, brief*/
        albumService.insert(new Album("3","gxs","fgd",10.0,"dfg","dfgs",new Date(),"sdfgfdfg"));
    }
}

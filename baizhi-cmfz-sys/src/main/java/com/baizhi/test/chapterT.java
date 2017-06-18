package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")

public class chapterT {
    @Autowired
    private ChapterService chapterService;
    @Test
    public void test(){
        List<Chapter> chapters = chapterService.selectAll();
        System.out.println(chapters);
    }
    @Test
    public void testAdd(){
        /*id, title, url, csize, duration,pid*/
        Album album = new Album();
        album.setId("1");
        chapterService.insert(new Chapter("1","aaa","d:/dddd","10",album,"15"));
    }
}

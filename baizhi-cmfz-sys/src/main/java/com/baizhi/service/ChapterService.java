package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public interface ChapterService {

    void delete(String id);

    void insert(Chapter chapter);

    Chapter selectOne(String id);

    void update(Chapter chapter);

    public List<Chapter> selectAll();
}

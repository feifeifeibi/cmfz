package com.baizhi.service;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/16.
 */

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterMapper chapterMapper;

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

    public void insert(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapterMapper.insert(chapter);
    }

    public Chapter selectOne(String id) {
        Chapter chapter = chapterMapper.selectByPrimaryKey(id);
        return chapter;
    }

    public void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    public List<Chapter> selectAll() {
        List<Chapter> chapters = chapterMapper.selectAll();
        return chapters;
    }
}

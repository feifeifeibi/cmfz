package com.baizhi.service;

import com.baizhi.dao.EssayMapper;
import com.baizhi.entity.Essay;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
@Service
@Transactional
public class EssayServiceImpl implements EssayService{
    @Autowired
    private EssayMapper essayMapper;



    public void insert(Essay essay) {
        essayMapper.insert(essay);
    }

    public void delete(String id) {
        essayMapper.deleteByPrimaryKey(id);
    }

    public Essay selectOne(String id) {
        Essay essay = essayMapper.selectByPrimaryKey(id);
        return essay;
    }

    public void update(Essay essay) {
        essayMapper.updateByPrimaryKey(essay);
    }

    public List<Essay> selectAll() {
        List<Essay> essays = essayMapper.selectAll();
        return essays;
    }
}

package com.baizhi.service;

import com.baizhi.entity.Essay;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
public interface EssayService {

    public void insert(Essay essay);

    public void delete(String id);

    public Essay selectOne(String id);

    public void update(Essay essay);

    public List<Essay> selectAll();


}

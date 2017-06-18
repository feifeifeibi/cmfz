package com.baizhi.dao;

import com.baizhi.entity.Essay;
import com.baizhi.entity.Guru;

import java.util.List;

public interface EssayMapper {
    int deleteByPrimaryKey(String id);

    int insert(Essay record);

    Essay selectByPrimaryKey(String id);

    int updateByPrimaryKey(Essay record);

    List<Essay> selectAll();
}
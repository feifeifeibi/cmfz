package com.baizhi.dao;

import com.baizhi.entity.Guru;

public interface GuruMapper {
    int deleteByPrimaryKey(String id);

    int insert(Guru record);

    Guru selectByPrimaryKey(String id);

    int updateByPrimaryKey(Guru record);
}
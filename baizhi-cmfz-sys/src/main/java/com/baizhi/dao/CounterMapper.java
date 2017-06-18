package com.baizhi.dao;

import com.baizhi.entity.Counter;

public interface CounterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Counter record);

    Counter selectByPrimaryKey(String id);

    int updateByPrimaryKey(Counter record);
}
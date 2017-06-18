package com.baizhi.dao;

import com.baizhi.entity.City;

public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    City selectByPrimaryKey(String id);

    int updateByPrimaryKey(City record);
}
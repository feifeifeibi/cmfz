package com.baizhi.dao;

import com.baizhi.entity.Province;

public interface ProvinceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Province record);

    Province selectByPrimaryKey(String id);

    int updateByPrimaryKey(Province record);
}
package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerMapper {

    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    public List<Banner> selectAll();

    Banner selectByPrimaryKey(String id);

    int updateByPrimaryKey(Banner record);
}
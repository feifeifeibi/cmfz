package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectAll();
}
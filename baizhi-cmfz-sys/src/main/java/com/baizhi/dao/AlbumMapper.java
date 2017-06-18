package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(String id);

    int insert(Album record);

    Album selectByPrimaryKey(String id);

    int updateByPrimaryKey(Album record);

    List<Album> selectAll();
}
package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface AlbumService {

    public void insert(Album album);

    public void delete(String id);

    public Album selectOne(String id);

    public void update(Album album);

    public List<Album> selectAll();

}

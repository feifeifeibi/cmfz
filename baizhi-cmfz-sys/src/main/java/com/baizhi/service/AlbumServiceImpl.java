package com.baizhi.service;

import com.baizhi.dao.AdminMapper;
import com.baizhi.dao.AlbumMapper;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumMapper albumMapper;

    public void insert(Album album){
        album.setId(UUID.randomUUID().toString());
        album.setCreatedate(new Date());
        albumMapper.insert(album);
    }

    public void delete(String id){
        albumMapper.deleteByPrimaryKey(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album selectOne(String id){
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    public void update(Album album){
        albumMapper.updateByPrimaryKey(album);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> selectAll(){
        List<Album> albumList = albumMapper.selectAll();
        return albumList;
    }

}

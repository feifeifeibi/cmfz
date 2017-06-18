package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface BannerService {

    public void delete(String id);

    public void insert(Banner banner);

    public List<Banner> selectAll();

    public Banner selectOne(String id);

    public void update(Banner banner);
}

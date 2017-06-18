package com.baizhi.service;

import com.baizhi.dao.BannerMapper;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service("BannerService")
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerMapper bannerMapper;

    public void delete(String id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    public void insert(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerMapper.insert(banner);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Banner> selectAll() {
        List<Banner> banners = bannerMapper.selectAll();
        return banners;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Banner selectOne(String id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return banner;
    }

    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }
}

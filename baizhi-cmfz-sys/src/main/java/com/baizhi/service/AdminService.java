package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface AdminService {

    Admin selectByName(Admin admin);

    public void addAdmin(Admin admin);

}

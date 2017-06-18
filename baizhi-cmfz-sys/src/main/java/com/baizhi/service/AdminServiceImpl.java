package com.baizhi.service;

import com.baizhi.dao.AdminMapper;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.Admin;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/12.
 */

/*注解注册adminService*/
@Service("adminService")
/*创建事务*/
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminmapper;
    /*管理员登录*/
    public Admin selectByName(Admin admin){
        System.out.println();
        Admin dbadmin = adminmapper.selectByName(admin.getUsername());

        if(admin==null){
            throw new RuntimeException("该用户不存在");
        }else if(admin.getPassword().equals(admin.getPassword()+admin.getSalt())){
            throw new RuntimeException("密码输入错误");
        }else{
            return dbadmin;
        }
    }

    public void addAdmin(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        admin.setSalt(SaltUtil.getSalt(8));
        admin.setPassword(MD5Utils.getMD5(admin.getPassword()+admin.getSalt()));
        adminmapper.insert(admin);
    }
}

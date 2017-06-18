package com.baizhi.service;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public List<Integer> selectCount() {
        List<Integer> list = new ArrayList<Integer>();

        //从工厂里获取日历对象
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, -7);
        list.add(userMapper.selectCount(instance.getTime(), new Date()));

        Calendar instance1 = Calendar.getInstance();
        instance1.add(Calendar.MONTH, -1);
        list.add(userMapper.selectCount(instance1.getTime(), new Date()));

        Calendar instance2 = Calendar.getInstance();
        instance2.add(Calendar.MONTH, -3);
        list.add(userMapper.selectCount(instance2.getTime(), new Date()));

        Calendar instance3 = Calendar.getInstance();
        instance3.add(Calendar.MONTH, -6);
        list.add(userMapper.selectCount(instance3.getTime(), new Date()));

        Calendar instance4 = Calendar.getInstance();
        instance4.add(Calendar.YEAR, -1);
        list.add(userMapper.selectCount( instance4.getTime(),new Date()));
        return list;


    }
}

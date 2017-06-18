package com.baizhi.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/17.
 */
public interface UserService {

    public List<Integer> selectCount();
}

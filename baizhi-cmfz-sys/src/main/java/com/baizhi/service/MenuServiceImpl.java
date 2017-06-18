package com.baizhi.service;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /*查询方法不用控制事务*/
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> selectAll(){
        List<Menu> list = menuMapper.selectAll();
        return list;
    }
}

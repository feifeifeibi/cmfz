package com.baizhi.controller;

import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @ResponseBody
    @RequestMapping("/selectCount")
    public Map<String,Object> selectCount(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Integer> list = userService.selectCount();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("一周");
        strings.add("一月");
        strings.add("一季");
        strings.add("半年");
        strings.add("一年");
        map.put("counts",list);
        map.put("time",strings);

        return map;
    }

}

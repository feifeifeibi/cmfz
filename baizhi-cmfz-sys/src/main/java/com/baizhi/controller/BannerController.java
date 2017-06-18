package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/15.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;


    @RequestMapping("/delete")
    public void delete(String id){
        bannerService.delete(id);
    }


    @RequestMapping("/insert")
    public void insert(Banner banner, MultipartFile pic, HttpServletRequest request) throws IOException {
        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(pic.getName());
        // 获取文件类型
        String contentType = pic.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        pic.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        banner.setHref(webapps + "\\files\\"+newName+contentType.split("/")[1]);

        System.out.println(banner);
        bannerService.insert(banner);
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Banner> selectAll(){
        List<Banner> banners = bannerService.selectAll();
        return banners;
    }

    @ResponseBody
    @RequestMapping("/selectOne")
    public Banner selectOne(String id){
        Banner banner = bannerService.selectOne(id);
        return banner;
    }


    @RequestMapping("/update")
    public void update(Banner banner,MultipartFile pic,HttpServletRequest request) throws IOException {
        // 获取当前时间
        Date date = new Date();
        // 创建新文件名
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(date);
        String newName = UUID.randomUUID().toString().replace("-", "") + format+"."+ FilenameUtils.getExtension(pic.getName());
        // 获取文件类型
        String contentType = pic.getContentType();
        // 获取服务器的根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // 获取父亲目录
        String webapps = new File(realPath).getParent();
        // 自动创建文件夹
        File file = new File(webapps + "/files");
        if (!file.exists()) {
            file.mkdirs();
        }
        pic.transferTo(new File(webapps + "/files",newName+contentType.split("/")[1]));
        banner.setHref(webapps + "\\files\\"+newName+contentType.split("/")[1]);




        bannerService.update(banner);
    }
}

package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
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
@RequestMapping("album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @RequestMapping("/insert")
    public void insert(Album album, MultipartFile pic, HttpServletRequest request) throws IOException {
        System.out.println(album);
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
        album.setThumbnail(webapps + "\\files\\"+newName+contentType.split("/")[1]);


        albumService.insert(album);
    }
    @RequestMapping("/delete")
    public void delete(String id){
        albumService.delete(id);
    }
    @ResponseBody
    @RequestMapping("/selectOne")
    public Album selectOne(String id){
        Album album = albumService.selectOne(id);
        return album;
    }
    @RequestMapping("/update")
    public void update(Album album, MultipartFile pic, HttpServletRequest request) throws IOException {

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
        album.setThumbnail(webapps + "\\files\\"+newName+contentType.split("/")[1]);


        albumService.update(album);
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Album> selectAll(){
        List<Album> albumList = albumService.selectAll();
        return albumList;
    }
}

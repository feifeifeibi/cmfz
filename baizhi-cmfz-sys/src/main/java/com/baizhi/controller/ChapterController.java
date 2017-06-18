package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/delete")
    public void delete(String id){
        chapterService.delete(id);
    }

    @RequestMapping("/insert")
    public void insert(Chapter chapter, MultipartFile pic, HttpServletRequest request) throws IOException {

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
        chapter.setUrl(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        chapter.setCsize(String.valueOf(pic.getSize()));

        chapterService.insert(chapter);
    }

    @ResponseBody
    @RequestMapping("/selectOne")
    public Chapter selectOne(String id){
        Chapter chapter = chapterService.selectOne(id);
        return chapter;
    }

    @RequestMapping("/update")
    public void update(Chapter chapter, MultipartFile pic, HttpServletRequest request) throws IOException {

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
        chapter.setUrl(webapps + "\\files\\"+newName+contentType.split("/")[1]);
        chapter.setCsize(String.valueOf(pic.getSize()));
        chapterService.update(chapter);
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Chapter> selectAll(){
        List<Chapter> chapters = chapterService.selectAll();
        return chapters;
    }

}

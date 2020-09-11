package com.hyy.fastdfs.controller;

import com.hyy.fastdfs.util.FastDFSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 黄大大
 * @file fastdfs
 * @creat 2020-09-10 10:07
 */
@Controller
public class FsatFDSController {
    @Autowired
    private FastDFSClientUtil clientUtil;

    /**
     * 文件下载
     * @param fileUrl
     * @return
     */
    @RequestMapping("/download")
    @ResponseBody
    public byte[] downloadFile(String fileUrl){
        return clientUtil.downloadFile("group1/M00/00/00/wKgr0V9ZkH6AIq_JAAAg2jn0LiI783.jpg");
    }


    /**
     * 文件上传
     * @param mf
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile mf){
        try {
            String upload = clientUtil.upload(mf);
            return upload;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
    @RequestMapping("/page")
    public String page(){
        return "index";
    }

}

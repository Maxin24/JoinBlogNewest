package com.join.joinblog.controller.util;


import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import static java.lang.System.out;


/**
 * @Author:dongml
 * @Description:
 * @Date:21:47 2019/10/12
 */

@Controller
@CrossOrigin
public class UtilController {

    @RequestMapping(value = "/picupload",method = RequestMethod.POST)
    public String MutiFileUpload(HttpSession session, HttpServletRequest request, @RequestParam(value = "picfile", required=false)MultipartFile[] files){
        /**
         * 建立的多输入文件上传方法
         * */
        // System.out.println(request.getSession().getServletContext().getRealPath("blog"+File.separator+"uploadfiles"));
        String toadress1 = null;
        //String toadress2 = null;
        String info = null;
        boolean flag = true;
        //获取项目的根目录
        String path = request.getSession().getServletContext().getRealPath("static"+File.separator+"uploadfiles");
        for(int i=0;i<files.length;i++){
            MultipartFile files1 = files[i];
            //如果第一个文件就是空的，错误。
            if(!files1.isEmpty()){
                if(i==0 || i == 1){
                    info = "please uploda files";
                }

                String fileOriginName = files1.getOriginalFilename();
                String afterfile = FilenameUtils.getExtension(fileOriginName);

                if(afterfile.equalsIgnoreCase("md") || afterfile.equalsIgnoreCase("txt")){
                    if(afterfile.equalsIgnoreCase("md")) {
                        toadress1 = "/mdfiles";
                    }
                    else if (afterfile.equalsIgnoreCase("txt")){
                        toadress1 = "/txtfiles";
                    }
                    String filename = path + toadress1;
                    File target = new File(path,filename);
                    if(target.exists()){
                        target.mkdir();
                    }
                    //文件的transfer传输到目标文件
                    try{
                        files1.transferTo(target);
                    }catch (Exception e){
                        e.printStackTrace();
                        session.setAttribute(info,"不可抗力因素失败");
                    }

                    if(i == 0){
                        toadress1 = path + File.separator +fileOriginName;
                    }
                }else {
                    session.setAttribute(info,"文档格式不正确");
                    flag = false;
                }
            }
        }
        return toadress1;
    }

    @RequestMapping(value = "/fileupload")
    public String fileupload(HttpSession session,HttpServletRequest request,MultipartFile pic)throws IOException {
        /**
         * 建立单文件（图片）的上传
         */
        String endPath = "error";
        String targetPath = null;
        if(!pic.isEmpty()){
            String originName = pic.getOriginalFilename();
            String afterName = FilenameUtils.getExtension(originName);
            String rootPath = request.getSession().getServletContext().getRealPath("/static"+File.separator+"uploadfiles");
            System.out.println(rootPath);
            if(afterName.equalsIgnoreCase("png") || afterName.equalsIgnoreCase("jpg") || afterName.equalsIgnoreCase("jpeg")){
                targetPath = rootPath + File.separator +"pictures";
                File file  = new File(targetPath);
                pic.transferTo(file);
            }else {
                return "fail";
            }
        }
        return endPath;
    }

//    @RequestMapping(value = "/words-IN")
//    public String words-in(HttpSession session,HttpServletRequest request,String str){
//
//    }
}

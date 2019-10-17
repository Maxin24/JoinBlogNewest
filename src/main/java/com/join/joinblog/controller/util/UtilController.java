package com.join.joinblog.controller.util;

import ch.qos.logback.core.util.SystemInfo;
import com.join.joinblog.entity.blog.Blog;
import com.join.joinblog.service.user.UserService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.LimitExceededException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

import static java.lang.System.console;
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
                        toadress1 = "/upload";
                    }
                    else if (afterfile.equalsIgnoreCase("txt")){
                        toadress1 = "/upload";
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
    @ResponseBody
    public String fileupload(HttpServletRequest request,@RequestParam(value = "file", required=false)MultipartFile pic)throws IOException {
        /**
         * 建立单文件（图片）的上传
         */
        String info = "error";
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        String filepath = path.getParentFile().getParentFile().getParent()+File.separator+"upload"+File.separator;
        if(!pic.isEmpty()){
            String originName = pic.getOriginalFilename();
            String afterName = FilenameUtils.getExtension(originName);
            File file1 = new File("/opt/joinblog");
            File file  = new File(file1.getAbsoluteFile(),"upload"+File.separator+"pictures"+File.separator+originName);
            //String rootPath = request.getSession().getServletContext().getRealPath("upload"+File.separator);
            if(afterName.equalsIgnoreCase("png") || afterName.equalsIgnoreCase("jpg") || afterName.equalsIgnoreCase("jpeg")){
                //String targetPath = rootPath  +"/pictures";
                try {
                    pic.transferTo(file);
                    info = "true";
                }catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }else {
                info = "请上传正确类型文件！";
            }
        }
        System.out.println();
        return info;
    }


    @RequestMapping(value = "/wordupload")
    @ResponseBody
    public String wordupload(@RequestParam(value = "file", required=false)MultipartFile words)throws IOException {
        /**
         * 建立单文件（图片）的上传
         */
        String info = "error";
        String finalPath = "error";
        String targetPath = null;
        if(!words.isEmpty()){
            String originName = words.getOriginalFilename();
            String afterName = FilenameUtils.getExtension(originName);
            File file  = null;
            // String rootPath = request.getSession().getServletContext().getRealPath("/static"+File.separator+"uploadfiles");
            String rootPath = "/opt/joinblog";
            if(afterName.equalsIgnoreCase("doc") || afterName.equalsIgnoreCase("txt") || afterName.equalsIgnoreCase("md")|| afterName.equalsIgnoreCase("docx")){
                targetPath = rootPath  +"/words";
                finalPath = targetPath + "/" +originName;
                file  = new File(targetPath,originName);
                try {
                    words.transferTo(file);
                    // info = "true";
                    info = finalPath;
                }catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }else {
                info = "请上传正确类型文件！";
            }
        }
        System.out.println(finalPath);
        return info;
    }

    @ResponseBody
    @RequestMapping(value = "/turningdownload")
    public String turningdownload(@RequestParam(value = "name")int id) {
        String str = null;
        String adress = "/opt/joinblog/upload/turning";
        String target = adress  +"/"+id+".txt";
        File file = new File(target);
        if(file.exists()){
            try {
                str = readFileContent(target);
            }catch (IOException e){
                str = "文件不存在";
                e.printStackTrace();
            }
        }
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/download")
    public String download(@RequestParam(value = "userid")int id,@RequestParam(value = "title")String title)throws FileNotFoundException {
        String str = null;
        String adress = "/opt/joinblog/upload/words/blog";
//        for(int i = 0;i < adress.length();i++){
//            if(adress.charAt(i) == '/'){
//                adress.replace('/','\\');
//            }
//        }

        String endstr = null;
        //这里还需要修改文件名称！
        String target = adress  +"/"+id+title+".txt";
        File file = new File(target);
        if(file.exists()){
            try {
                str = readFileContent(target);
            }catch (IOException e){
                str = "文件不存在";
                e.printStackTrace();
            }
        }
        return str;
    }

    private static String readFileContent(String fileName) throws IOException {
        File file = new File(fileName);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
        BufferedReader bf = new BufferedReader(isr);
        String content = "";
        StringBuilder sb = new StringBuilder();
        while(content != null){
            content = bf.readLine();
            if(content == null){
                break;
            }
            sb.append(content.trim());
        }
        bf.close();
        return sb.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/wordstreamupload")
    public String wordstreamupload(@RequestParam(value = "content", required=false)String str,@RequestParam(value = "title", required=false)String title,@RequestParam(value = "mdcontent")String mdcontent,@RequestParam(value = "userid")String id){
        String words_to = "/opt/joinblog/upload/words/blog";
        String info = "error";
        String filename = words_to + "/"+id+title+".txt";
        String filename1 = words_to + "/"+id+title+"md.txt";
        File file = new File(filename);
        File file1 = new File(filename1);
        if(str == null || mdcontent == null){
            return "传输内容为空，请核实。";
        }
        try {
            PrintStream out = new PrintStream(file);
            out.print(str);
            PrintStream out1 = new PrintStream(file1);
            out1.print(mdcontent);
            out.close();
            out1.close();
            info = "保存成功";
        }catch (FileNotFoundException r){
            info = "文件创建失败";
        }
        return info;
    }
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/pictreamupload")
    public String pictreamupload(@RequestParam(value = "content", required=false)String str,@RequestParam(value = "userid", required=false)int id){
        String words_to = "/opt/joinblog/upload/words/user";
        //文件特异的名称
        String info = "error";
        String filename = words_to + "/"+id+".txt";
        File file = new File(filename);
        if(str == null || id == 0){
            return "传输内容为空，请核实。";
        }
        try {
            PrintStream out = new PrintStream(file);
            out.print(str);
            out.close();
            info = "保存成功";
        }catch (FileNotFoundException r){
            info = "文件创建失败";
        }
        File file1 = new File(filename);
        if(file1.exists()){
            try {
                str = readFileContent(filename);
            }catch (IOException e){
                str = "文件不存在";
                e.printStackTrace();
            }
        }
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/turningupload")
    public String turningupload(@RequestParam(value = "content", required=false)String str,@RequestParam(value = "name", required=false)String name){
        String words_to = "/opt/joinblog/upload/turning";
        String info = "error";
        String filename = words_to + "/"+name+".txt";
        File file = new File(filename);
        if(str == null || name == null){
            return "传输内容为空，请核实。";
        }
        try {
            PrintStream out = new PrintStream(file);
            out.print(str);
            out.close();
            info = "保存成功";
        }catch (FileNotFoundException r){
            info = "文件创建失败";
        }
        File file1 = new File(filename);
        if(file1.exists()){
            try {
                str = readFileContent(filename);
            }catch (IOException e){
                str = "文件不存在";
                e.printStackTrace();
            }
        }
        return filename;
    }

}


package com.join.joinblog.controller.user;

import com.join.joinblog.entity.user.User;
import com.join.joinblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:41 2019/9/2
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login")
    public User login(String username, String password, Map<String, Object> map) throws Exception{
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user=userService.login(user);
        System.out.println("aaa"+user);
//        if(user==null){
//            if(!userService.judgeUsername(username)){
//                map.put("message","该用户不存在");
//            }
//            else {
//                map.put("massage","密码错误");
//            }
//        }
//        map.put("user",user);
//        System.out.println(map);
//        System.out.println(user);
//        return map;
        return user;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @throws Exception
     */
    @RequestMapping(value = "/addUser")
    public String addUser(String username, String password) throws Exception{
        boolean b=userService.judgeUsername(username);
        if(b){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.addUser(user);
            return "注册成功";
        }
        else {
            return "用户名已被占用";
        }
    }

    /**
     * 更新个人信息
     * @param user
     * @throws Exception
     */
    @RequestMapping(value = "/update")
    public void updateUser(User user) throws Exception{
        userService.updateUser(user);
    }

    /**
     * 删除普通管理
     * @param user
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    public void deleteUser(User user) throws Exception{
        userService.deleteUser(user);
    }
    /**
     * 上传头像
     * @param file user
     * @throws Exception
     */
    @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String uploadHead(@RequestParam("fileName") MultipartFile file,User user){

        System.out.print("上传头像==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传头像不可为空";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();

        fileName = user.getId()+user.getUsername();

        user.setPath("E:/fileUpload/" +fileName);

        //创建文件路径
        File dest = new File(user.getPath());

        //判断文件是否已经存在
        if (dest.exists()) {
            return "头像已经存在";
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            //System.out.print("保存文件路径"+user.getPath()+"\n");
            user.setHeadUrl("http://localhost:8082/images/"+fileName);
            userService.uploadHead(user);

        } catch (Exception e) {
            return "头像上传失败";
        }

        return "头像上传成功";
    }

    /**
     * 列出user
     * @param
     * @throws Exception
     */
    @RequestMapping(value = "/listUser")
    public List<User> listUser() throws Exception{

        return userService.listUser();
    }


}

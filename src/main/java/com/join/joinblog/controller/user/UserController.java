package com.join.joinblog.controller.user;

import com.join.joinblog.entity.user.User;
import com.join.joinblog.service.blog.impl.BlogServiceImpl;
import com.join.joinblog.service.invitecode.impl.InviteCodeServiceImpl;
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
    @Autowired
    private InviteCodeServiceImpl inviteCodeService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login")
    public User login(String username, String password) throws Exception{
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
     * 根据邀请码注册
     * @param username
     * @param password
     * @throws Exception
     */
    @RequestMapping(value = "/addUser")
    public String addUser(String username, String password,String inviteStr) throws Exception{
       if(userService.judgeUsername(username)){
           if(inviteCodeService.deleteCode(inviteStr)){
               User user = new User();
               user.setUsername(username);
               user.setPassword(password);
               userService.addUser(user);
               return "注册成功";
           }
           else {
               return "注册码错误";
           }
       }
        else return "用户名已被占用";
    }

    /**
     * 更新个人信息
     * @param user
     * @throws Exception
     */
    @RequestMapping(value = "/update")
    public int updateUser(User user) throws Exception{
        return userService.updateUser(user);
    }

    /**
     * 删除普通管理
     * @param user
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    public int deleteUser(User user) throws Exception{
        return userService.deleteUser(user);
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
            userService.uploadHead(1,"","");

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
    /**
     * 通过id获取所有fans
     * @param
     * @throws Exception
     */
    @RequestMapping(value = "/listFans")
    public List<User> listMyFans(int id) throws Exception{
        return userService.listFans(id);
    }
    /**
     * 通过id获取所有focus
     * @param
     * @throws Exception
     */
    @RequestMapping(value = "/listFocus")
    public List<User> listMyFocus(int id) throws Exception{
        return userService.listFocus(id);
    }
    /**
     * 模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/fuzzyQuery")
    public List<User> fuzzyQuery(String name) throws Exception{
        return userService.fuzzyQuery(name);
    }
    /**
     * 模糊查询
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/queryHead")
    public User queryHead(String username) throws Exception{
        return userService.queryUserByUsername(username);
    }

    /**
     * 增加粉丝
     * @param id
     * @param id2
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addFans")
    public int addFans(int id,int id2) throws Exception{
        List l=userService.listFans(id);
        String str;
        if (l.size()==0){
            str=String.valueOf(id2);
            return userService.addFans(id,str);
        }
        else{
            str=","+id2;
            return userService.addFans(id,str);
        }
    }
    /**
     * 增加粉丝
     * @param id
     * @param id2
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteFans")
    public int deleteFans(int id,int id2) throws Exception{
        String str=String.valueOf(id2);
        return userService.deleteFans(id,str+",");
    }
    /**
     * 增加粉丝
     * @param id
     * @param id2
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteFocus")
    public int deleteFocus(int id,int id2) throws Exception{
        String str=String.valueOf(id2);
        return userService.deleteFocus(id,str+",");
    }

    /**
     * 增加关注
     * @param id
     * @param id2
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addFocus")
    public int addFocus(int id,int id2) throws Exception{
        List l=userService.listFocus(id);
        String str;
        if (l==null){
            str=String.valueOf(id2);
            return userService.addFocus(id,str);
        }
        else{
            str=","+id2;
            return userService.addFocus(id,str);
        }
    }

}

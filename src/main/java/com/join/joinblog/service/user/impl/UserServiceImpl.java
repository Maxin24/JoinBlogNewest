package com.join.joinblog.service.user.impl;

import com.join.joinblog.entity.blog.Blog;
import com.join.joinblog.entity.user.User;
import com.join.joinblog.mapper.user.UserMapper;
import com.join.joinblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:03 2019/9/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public User login(User user) throws Exception{
        User user1=userMapper.login(user);
        return user1;
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public void addUser(User user) throws Exception{
        userMapper.addUser(user);
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateUser(User user) throws Exception{
        return userMapper.updateUser(user);
    }
    /**
     * 删除
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int deleteUser(User user) throws Exception{
        return userMapper.deleteUser(user);
    }
    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<User> listUser() throws Exception{
        return userMapper.listUser();
    }
    /**
     * 判断用户名
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean judgeUsername(String name) throws Exception{
        boolean b=true;
        List<User> list=userMapper.listUser();
        for(int i=0;i<list.size();i++){
            User user=list.get(i);
            if(user.getUsername().equals(name)){
                b=false;
                return b;
            }
        }
        return b;
    }
    /**
     * 上传头像
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int uploadHead(int id,String path,String headUrl) throws Exception{
        return userMapper.uploadHead(id,path,headUrl);

    }
    /**
     * 获取博客数
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int setBlogCount() throws Exception{
        int n=userMapper.setBlogCount().size();
        return n;

    }
    /**
     * 获取粉丝数
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int setFansCount() throws Exception{

        int n=0;
        //n=userMapper.setFansCount().size();
        return n;

    }
    /**
     * 获取关注数
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int setFocusCount() throws Exception{

        int n=0;
        //n=userMapper.setFocusCount().size();
        return n;

    }
    /**
     * 列出粉丝
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<User> listFans(int id) throws Exception{
        List<User> list=new ArrayList<>();
        String a=userMapper.queryFans(id);
        String[] x=a.split(",");
        for(int i=0;i<x.length;i++){
            int e=Integer.parseInt(x[i]);
            User user=userMapper.queryUser(e);
            list.add(user);
        }
        return list;
    }
    /**
     * 增加粉丝
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int addFans(int id,String str) throws Exception{
        String a=userMapper.queryFans(id);
        a=a+str;
        return userMapper.addFans(id,a);
    }
    /**
     * 增加粉丝
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int deleteFans(int id,String str) throws Exception{
        String a=userMapper.queryFocus(id);
        a=a.replaceAll(str,"");
        return userMapper.addFans(id,a);
    }
    /**
     * 增加关注
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int addFocus(int id,String str) throws Exception{
        String a=userMapper.queryFocus(id);
        a=a+str;
        return userMapper.addFocus(id,a);
    }
    /**
     * 增加关注
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int deleteFocus(int id,String str) throws Exception{
        String a=userMapper.queryFocus(id);
        a=a.replaceAll(str,"");
        return userMapper.addFocus(id,a);
    }
    /**
     * 列出关注
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<User> listFocus(int id) throws Exception{
        List<User> list=new ArrayList<>();
        String a=userMapper.queryFocus(id);
        if(a==null){
            return null;
        }
        else{
            String[] x=a.split(",");
            for(int i=0;i<x.length;i++){
                int e=Integer.parseInt(x[i]);
                User user=userMapper.queryUser(e);
                list.add(user);
            }
            return list;
        }
    }
    /**
     * 模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public User queryUserByUsername(String name) throws Exception{
        return userMapper.queryUserByUsername(name);
    }

    /**
     * 模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<User> fuzzyQuery(String name) throws Exception{
        System.out.println(name);
        return userMapper.fuzzyQuery(name);
    }
    /**
     * 模糊查询
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public User queryUser(int id) throws Exception{
        return userMapper.queryUser(id);
    }

}

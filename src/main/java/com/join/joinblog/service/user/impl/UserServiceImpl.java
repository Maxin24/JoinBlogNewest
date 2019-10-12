package com.join.joinblog.service.user.impl;

import com.join.joinblog.entity.user.User;
import com.join.joinblog.mapper.user.UserMapper;
import com.join.joinblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean updateUser(User user) throws Exception{
        boolean b=userMapper.updateUser(user);
        return b;
    }
    /**
     * 删除
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUser(User user) throws Exception{
        boolean b=userMapper.deleteUser(user);
        return b;
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
            User user=(User)list.get(i);
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
    public void uploadHead(User user) throws Exception{

        userMapper.uploadHead(user);

    }

}

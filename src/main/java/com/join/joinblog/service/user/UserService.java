package com.join.joinblog.service.user;

import com.join.joinblog.entity.user.User;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:04 2019/9/2
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    public User login(User user) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    public void addUser(User user) throws Exception;

    /**
     * 修改个人信息
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    /**
     * 删除
     * @param user
     * @return
     * @throws Exception
     */
    public int deleteUser(User user) throws Exception;

    /**
     * 列出所有user
     * @param
     * @return
     * @throws Exception
     */
    public List<User> listUser() throws Exception;

    /**
     * 判断用户名是否重复
     * @param
     * @return
     * @throws Exception
     */
    public boolean judgeUsername(String name)throws Exception;

    /**
     * 上传头像
     * @param
     * @return
     * @throws Exception
     */
    public int uploadHead(int id,String path,String headUrl)throws Exception;

    /**
     * 博客数
     * @param
     * @return
     * @throws Exception
     */
    public int setBlogCount()throws Exception;
    /**
     * 粉丝数
     * @param
     * @return
     * @throws Exception
     */
    public int setFansCount()throws Exception;
    /**
     * 关注数
     * @param
     * @return
     * @throws Exception
     */
    public int setFocusCount()throws Exception;

    /**
     * 列出粉丝
     * @param
     * @return
     * @throws Exception
     */
    public List<User> listFans(int id)throws Exception;
    /**
     * 列出关注
     * @param
     * @return
     * @throws Exception
     */
    public List<User> listFocus(int id)throws Exception;
    /**
     * 模糊查询用户
     */
    public List<User> fuzzyQuery(String name) throws Exception;
    /**
     * 模糊查询用户
     */
    public User queryUserByUsername(String name) throws Exception;
    /**
     * 模糊查询用户
     */
    public User queryUser(int id) throws Exception;
    /**
     * 增加粉丝
     */
    public int addFans(int id,String str) throws Exception;
    /**
     * 增加粉丝
     */
    public int deleteFans(int id,String str) throws Exception;
    /**
     * 增加关注
     */
    public int addFocus(int id,String str) throws Exception;
    /**
     * 增加关注
     */
    public int deleteFocus(int id,String str) throws Exception;


}

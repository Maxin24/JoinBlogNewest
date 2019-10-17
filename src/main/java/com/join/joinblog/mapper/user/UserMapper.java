package com.join.joinblog.mapper.user;

import com.join.joinblog.entity.blog.Blog;
//import com.join.joinblog.entity.fans.Fans;
//import com.join.joinblog.entity.focus.Focus;
import com.join.joinblog.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:41 2019/9/2
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    public User login(@Param("user")User user) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    public boolean addUser(@Param("user")User user)throws Exception;

    /**
     * 更新个人信息
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(@Param("user") User user)throws Exception;

    /**
     * 删除
     * @param user
     * @return
     * @throws Exception
     */
    public int deleteUser(@Param("user") User user)throws Exception;

    /**
     * 列出所有user
     * @return
     * @throws Exception
     */
    public List<User> listUser()throws Exception;

    /**
     * 上传头像
     * @return
     * @throws Exception
     */
    public int uploadHead(@Param("id")int id,@Param("path")String path,@Param("headUrl")String headUrl)throws Exception;
    /**
     * 博客数
     * @return
     * @throws Exception
     */
    public List<Blog> setBlogCount()throws Exception;
//    /**
//     * 粉丝数
//     * @return
//     * @throws Exception
//     */
//    public List<Fans> setFansCount()throws Exception;
//    /**
//     * 关注数
//     * @return
//     * @throws Exception
//     */
//    public List<Focus> setFocusCount()throws Exception;
    /**
     * 增加粉丝
     * @return
     * @throws Exception
     */
    public int addFans(@Param("id")int id,@Param("str")String str)throws Exception;
    /**
     * 增加粉丝
     * @return
     * @throws Exception
     */
    public int deleteFans(@Param("id")int id,@Param("str")String str)throws Exception;
    /**
     * 增加关注
     * @return
     * @throws Exception
     */
    public int addFocus(@Param("id")int id,@Param("str")String str)throws Exception;
    /**
     * 增加关注
     * @return
     * @throws Exception
     */
    public int deleteFocus(@Param("id")int id,@Param("str")String str)throws Exception;
    /**
     * 获取粉丝字段
     * @return
     * @throws Exception
     */
    public String queryFans(@Param("id")int id)throws Exception;
    /**
     * id查询user
     * @return
     * @throws Exception
     */
    public User queryUser(@Param("id")int id)throws Exception;
    /**
     * username查询user
     * @return
     * @throws Exception
     */
    public User queryUserByUsername(@Param("username")String username)throws Exception;
    /**
     * 获取关注字段
     * @return
     * @throws Exception
     */
    public String queryFocus(@Param("id")int id)throws Exception;
    /**
     * 模糊查询
     */
    public List<User> fuzzyQuery(@Param("username")String username) throws Exception;

}

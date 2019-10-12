package com.join.joinblog.mapper.user;

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
    public boolean updateUser(@Param("user") User user)throws Exception;

    /**
     * 删除
     * @param user
     * @return
     * @throws Exception
     */
    public boolean deleteUser(@Param("user") User user)throws Exception;

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
    public boolean uploadHead(@Param("user") User user)throws Exception;

}

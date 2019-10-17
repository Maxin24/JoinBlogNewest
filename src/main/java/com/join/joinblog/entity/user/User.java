package com.join.joinblog.entity.user;


import java.util.Arrays;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:54 2019/9/2
 */

public class User {

    int id;
    String username;
    String sex;
    String password;
    String headUrl;
    String path;
    String nickname;
    int blogCount;
    int blog[]=new int[blogCount];
    int focusCount;
    int focus[]=new int[focusCount];
    int fansCount;
    int fans[]=new int[fansCount];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int[] getBlog() {
        return blog;
    }

    public void setBlog(int[] blog) {
        this.blog = blog;
    }

    public int getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(int blogCount) {
        this.blogCount = blogCount;
    }

    public int[] getFocus() {
        return focus;
    }

    public void setFocus(int[] focus) {
        this.focus = focus;
    }

    public int getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(int focusCount) {
        this.focusCount = focusCount;
    }

    public int[] getFans() {
        return fans;
    }

    public void setFans(int[] fans) {
        this.fans = fans;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", path='" + path + '\'' +
                ", nickname='" + nickname + '\'' +
                ", blogCount=" + blogCount +
                ", blog=" + Arrays.toString(blog) +
                ", focusCount=" + focusCount +
                ", focus=" + Arrays.toString(focus) +
                ", fansCount=" + fansCount +
                ", fans=" + Arrays.toString(fans) +
                '}';
    }
}

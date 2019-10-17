package com.join.joinblog.entity.bookmarks;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 22:45 2019/9/4
 */

public class Bookmarks {

    private Integer id;

    private String bookmarksName;

    private String blogId;

    private String description;

    private String userId;

    private String blogName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookmarksName() {
        return bookmarksName;
    }

    public void setBookmarksName(String bookmarksName) {
        this.bookmarksName = bookmarksName;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    @Override
    public String toString() {
        return "Bookmarks{" +
                "id=" + id +
                ", bookmarksName='" + bookmarksName + '\'' +
                ", blogId='" + blogId + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                ", blogName='" + blogName + '\'' +
                '}';
    }
}

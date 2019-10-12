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

    @Override
    public String toString() {
        return "Bookmarks{" +
                "id=" + id +
                ", bookmarksName='" + bookmarksName + '\'' +
                ", blogId=" + blogId +
                '}';
    }
}

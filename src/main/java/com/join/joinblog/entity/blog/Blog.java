package com.join.joinblog.entity.blog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:ljx
 * @Date:2019/9/5
 * @Description: 博客实体类
 */
public class Blog {
    private int id;
    private int pv;
    private String releaseDate;
    private String releaseTime;
    private String commentsId;
    private int bloggerId;
    private String bloggerName;
    private String tags;
    private String title;
    private String mdUrl;
    private String htmlUrl;
    public Blog(){}

    public Blog(int bloggerId, String title,String bloggerName){
        this.bloggerName=bloggerName;
        this.bloggerId=bloggerId;
        this.title=title;

        this.pv=0;
        Date date=new Date();
        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat dateFormat2=new SimpleDateFormat("HH:mm");
        this.releaseDate=dateFormat1.format(date);
        this.releaseTime=dateFormat2.format(date);
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
    }

    public int getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(int bloggerId) {
        this.bloggerId = bloggerId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMdUrl() {
        return mdUrl;
    }

    public void setMdUrl(String mdUrl) {
        this.mdUrl = mdUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", pv=" + pv +
                ", releaseDate='" + releaseDate + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", commentsId='" + commentsId + '\'' +
                ", bloggerId=" + bloggerId +
                ", bloggerName=" + bloggerName +
                ", tags='" + tags + '\'' +
                ", title='" + title + '\'' +
                ", mdUrl='" + mdUrl + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}

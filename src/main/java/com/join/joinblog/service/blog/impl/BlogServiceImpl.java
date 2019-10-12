package com.join.joinblog.service.blog.impl;

import com.join.joinblog.entity.blog.Blog;
import com.join.joinblog.mapper.blog.BlogMapper;
import com.join.joinblog.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:ljx
 * @Date:2019/9/6
 * @Description:
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List fuzzyQueryByTitle(String title) {
        return blogMapper.fuzzyQueryByTitle(title);
    }

    @Override
    public void updateTitleById(String title, int id) {
        blogMapper.updateTitleById(title,id);
    }

    @Override
    public void addBLog(int bloggerId,String title,String bloggerName) {
        Date date=new Date();
        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat dateFormat2=new SimpleDateFormat("HH:mm");
        String releaseDate=dateFormat1.format(date);
        String releaseTime=dateFormat2.format(date);

        blogMapper.addBlog(0,releaseTime,releaseDate,bloggerId,bloggerName,title);
    }

    @Override
    public Blog queryById(int id) {
        return blogMapper.queryById(id);
    }

    @Override
    public List queryByBloggerId(int bloggerId) {
        return blogMapper.queryByBloggerId(bloggerId);
    }

    @Override
    public List queryAll() {
        return blogMapper.queryAll();
    }

    @Override
    public void updatePvById(int id) {
        Blog blog=blogMapper.queryById(id);
        blogMapper.updatePvById(blog.getPv()+1,id);
    }

    @Override
    public List queryByTag(String tag) {
        return blogMapper.queryByTag(tag);
    }

    @Override
    public void updateCommentsIdById(String commentsId, int id) {
        blogMapper.updateCommentsIdById(commentsId,id);
    }

    @Override
    public void updateTagsById(String tags, int id) {
        blogMapper.updateTagsById(tags,id);
    }

    @Override
    public void deleteById(int id) {
        blogMapper.deleteById(id);
    }

    @Override
    public int[] getBlogIds() {
        return blogMapper.getBlogIds();
    }
}

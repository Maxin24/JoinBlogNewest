package com.join.joinblog.service.blog.impl;

import com.join.joinblog.entity.blog.Blog;
import com.join.joinblog.mapper.blog.BlogMapper;
import com.join.joinblog.service.blog.BlogService;
import com.join.joinblog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    RedisUtil redisUtil;

    @Override
    public List fuzzyQueryByTitle(String title) {
        return blogMapper.fuzzyQueryByTitle(title);
    }



    @Override
    public int addBLog(int bloggerId,String title,String bloggerName) {
        Date date=new Date();
        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat dateFormat2=new SimpleDateFormat("HH:mm");
        String releaseDate=dateFormat1.format(date);
        String releaseTime=dateFormat2.format(date);

        return blogMapper.addBlog(0,releaseTime,releaseDate,bloggerId,bloggerName,title);
    }

    @Override
    public Blog queryById(int id) {
        Blog blog;
        String key="blog_"+id;
        boolean hasKey=redisUtil.hasKey(key);
        if(hasKey){
            long begin=System.currentTimeMillis();
            blog=(Blog)redisUtil.get(key);
            long end=System.currentTimeMillis();
            System.out.println("查找redis，花费时间："+(end-begin)+"ms");
        }else{
            long begin=System.currentTimeMillis();
            blog=blogMapper.queryById(id);
            long end=System.currentTimeMillis();
            System.out.println("查找mysql，花费时间："+(end-begin)+"ms");
            redisUtil.set(key,blog);
        }
        return blog;
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
    public int updatePvById(int id) {

        Blog blog=blogMapper.queryById(id);
        return blogMapper.updatePvById(blog.getPv()+1,id);
    }

    @Override
    public List queryByTag(String tag) {
        return blogMapper.queryByTag(tag);
    }

    @Override
    public int updateCommentsIdById(String commentsId, int id) {
        return blogMapper.updateCommentsIdById(commentsId,id);
    }

    @Override
    public int updateTagsById(String tags, int id) {
        return blogMapper.updateTagsById(tags,id);
    }

    @Override
    public boolean deleteById(int id) {
        String key="blog_"+id;
        int result=blogMapper.deleteById(id);
        if(result!=0) {
            boolean hasKey = redisUtil.hasKey(key);
            if (hasKey) {
                redisUtil.del(key);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTitleById(String title, int id) {
        String key="blog_"+id;
        int result=blogMapper.updateTitleById(title,id);
        if(result!=0) {
            boolean hasKey = redisUtil.hasKey(key);
            if (hasKey) {
                redisUtil.del(key);
            }
            Blog blog = blogMapper.queryById(id);
            redisUtil.set(key, blog);
            return true;
        }
        return false;
    }

    @Override
    public int[] getBlogIds() {
        return blogMapper.getBlogIds();
    }

    @Override
    public List getAllOrderByPv() {
        return blogMapper.getAllOrderByPv();
    }

    @Override
    public List getSomeOrderByPv(int num) {
        return blogMapper.getSomeOrderByPv(num);
    }

    @Override
    public List getAllOrderByDate() {
        return blogMapper.getAllOrderByDate();
    }

    @Override
    public List getSomeOrderByDate(int num) {
        return blogMapper.getSomeOrderByDate(num);
    }

    @Override
    public List fuzzyQueryByBLoggerNameOrTitle(String input) {
        return blogMapper.fuzzyQueryByBLoggerNameOrTitle(input);
    }

    @Override
    public boolean updateHtmlUrlById(String htmlUrl, int id) {
        if(blogMapper.updateHtmlUrlById(htmlUrl, id)!=0)
            return true;
        return false;
    }

    @Override
    public boolean updateMdUrlById(String mdUrl, int id) {
        if(blogMapper.updateMdUrlById(mdUrl, id)!=0)
            return true;
        return false;
    }
}

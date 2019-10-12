package com.join.joinblog.service.blog;

import com.join.joinblog.entity.blog.Blog;

import java.util.List;

/**
 * @Author:ljx
 * @Date:2019/9/6
 * @Description:
 */
public interface BlogService {
    void addBLog(int bloggerId, String title,String bloggerName);
    List fuzzyQueryByTitle(String title);
    Blog queryById(int id);
    List queryByBloggerId(int bloggerId);
    List queryByTag(String tag);
    List queryAll();
    void updateTitleById(String title, int id);
    void updatePvById(int id);
    void updateCommentsIdById(String commentsId, int id);
    void updateTagsById(String tags, int id);
    void deleteById(int id);
    int[] getBlogIds();
}

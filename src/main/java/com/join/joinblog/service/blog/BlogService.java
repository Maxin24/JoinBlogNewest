package com.join.joinblog.service.blog;

import com.join.joinblog.entity.blog.Blog;

import java.util.List;

/**
 * @Author:ljx
 * @Date:2019/9/6
 * @Description:
 */
public interface BlogService {
    int addBLog(int bloggerId, String title,String bloggerName);

    List fuzzyQueryByTitle(String title);
    Blog queryById(int id);
    List queryByBloggerId(int bloggerId);
    List queryByTag(String tag);
    List queryAll();
    int[] getBlogIds();
    List getAllOrderByPv();
    List getSomeOrderByPv(int num);
    List getAllOrderByDate();
    List getSomeOrderByDate(int num);

    int updateTitleById(String title, int id);
    int updatePvById(int id);
    int updateCommentsIdById(String commentsId, int id);
    int updateTagsById(String tags, int id);

    boolean deleteById(int id);


}

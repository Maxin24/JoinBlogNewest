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

    List fuzzyQueryByBLoggerNameOrTitle(String input);
    List fuzzyQueryByTitle(String title);
    List queryById(int id);
    List queryByBloggerId(int bloggerId);
    List queryByTag(String tag);
    List queryAll();
    int[] getBlogIds();
    List getAllOrderByPv();
    List getSomeOrderByPv(int num);
    List getAllOrderByDate();
    List getSomeOrderByDate(int num);

    boolean updateTitleById(String title, int id);
    boolean updateHtmlUrlById(String htmlUrl,int id);
    boolean updateMdUrlById(String mdUrl,int id);
    int updatePvById(int id);
    int updateCommentsIdById(String commentsId, int id);
    int updateTagsById(String tags, int id);

    boolean deleteById(int id);


}

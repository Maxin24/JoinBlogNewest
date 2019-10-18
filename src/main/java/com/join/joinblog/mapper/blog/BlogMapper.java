package com.join.joinblog.mapper.blog;

import com.join.joinblog.entity.blog.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:ljx
 * @Date:2019/9/6
 * @Description:
 */
@Repository
@Mapper
public interface BlogMapper {
    int addBlog(int pv, String releaseTime,String releaseDate, int bloggerId,String bloggerName, String title);

    List fuzzyQueryByBLoggerNameOrTitle(@Param("input") String input);
    List fuzzyQueryByTitle(@Param("title") String title);
    List queryById(@Param("id") int id);
    List queryByBloggerId(@Param("bloggerId") int bloggerId);
    List queryByTag(@Param("tag") String tag);
    List queryAll();
    List getAllOrderByPv();
    List getSomeOrderByPv(@Param("num") int num);
    List getAllOrderByDate();
    List getSomeOrderByDate(@Param("num") int num);
    List fuzzyQueryMyBlog(@Param("bloggerId")int bloggerId,@Param("input")String input,@Param("order")int order);
    int[] getBlogIds();

    int updateTitleById(@Param("title") String title, @Param("id") int id);
    int updatePvById(@Param("pv") int pv, @Param("id") int id);
    int updateCommentsIdById(@Param("commentsId") String commentsId, @Param("id") int id);
    int updateTagsById(@Param("tags") String tags, @Param("id") int id);
    int updateHtmlUrlById(@Param("htmlUrl") String htmlUrl,@Param("id") int id);
    int updateMdUrlById(@Param("mdUrl") String MdUrl,@Param("id") int id);

    int deleteById(@Param("id") int id);



}

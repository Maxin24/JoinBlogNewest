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
    void addBlog(int pv, String releaseTime,String releaseDate, int bloggerId,String bloggerName, String title);
    List fuzzyQueryByTitle(@Param("title") String title);
    Blog queryById(@Param("id") int id);
    List queryByBloggerId(@Param("bloggerId") int bloggerId);
    List queryByTag(@Param("tag") String tag);
    List queryAll();
    void updateTitleById(@Param("title") String title, @Param("id") int id);
    void updatePvById(@Param("pv") int pv, @Param("id") int id);
    void updateCommentsIdById(@Param("commentsId") String commentsId, @Param("id") int id);
    void updateTagsById(@Param("tags") String tags, @Param("id") int id);
    void deleteById(@Param("id") int id);
    int[] getBlogIds();
}

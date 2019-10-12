package com.join.joinblog.mapper.bookmarks;

import com.join.joinblog.entity.bookmarks.Bookmarks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 20:48 2019/9/5
 */
@Repository
@Mapper
public interface BookmarksMapper {
    public boolean addBookmarks(@Param("bookmarks")Bookmarks bookmarks)throws Exception;
    public boolean delBookmarks(@Param("id")int id)throws Exception;
    public boolean delBookmarksByName(@Param("bookmarksName")String bookmarksName)throws Exception;
    public List<Bookmarks> listBookmarks() throws Exception;
    public List<Bookmarks> queryBookmarks(@Param("bookmarksName")String bookmarksName) throws Exception;
    public boolean updateBookmarks(@Param("id")int id,@Param("bookmarksName")String bookmarksName)throws Exception;
    public boolean addBlogId(@Param("bookmarksName")String bookmarksName,@Param("blogId")String blogId)throws Exception;
    public Bookmarks queryBlogId(@Param("bookmarksName")String bookmarksName)throws Exception;

}

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
@Mapper
@Repository
public interface BookmarksMapper {
    public boolean addBookmarks(@Param("bookmarks")Bookmarks bookmarks)throws Exception;
    public boolean delBookmarks(@Param("id")int id)throws Exception;
    public boolean delBookmarksByName(@Param("bookmarksName")String bookmarksName)throws Exception;
    public List<Bookmarks> listBookmarks() throws Exception;
    public List<Bookmarks> queryBookmarks(@Param("bookmarksName")String bookmarksName) throws Exception;
    public boolean updateBookmarks(@Param("id")int id,@Param("bookmarksName")String bookmarksName)throws Exception;
    public boolean addBlogId(@Param("bookmarksName")String bookmarksName,@Param("blogId")String blogId)throws Exception;
    public Bookmarks queryBlogId(@Param("bookmarksName")String bookmarksName)throws Exception;
    public List<Bookmarks> listByName(@Param("userId")String userId) throws Exception;
    public boolean addBlog(@Param("blogId")String blogId,@Param("bookmarksName")String bookmarksName,@Param("blogName")String blogName,@Param("userId")String userId) throws Exception;
    public boolean delAllBlog(@Param("bookmarksName")String bookmarksName)throws Exception;
    public List<Bookmarks> listBlogName(@Param("bookmarksName")String bookmarksName)throws Exception;
    public List<Bookmarks> isDo(@Param("blogId")String blogId,@Param("userId")String userId)throws Exception;
    public boolean cancel(@Param("blogId")String blogId,@Param("userId")String userId)throws Exception;
}

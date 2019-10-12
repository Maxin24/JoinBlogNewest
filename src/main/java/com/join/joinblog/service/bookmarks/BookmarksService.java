package com.join.joinblog.service.bookmarks;

import com.join.joinblog.entity.bookmarks.Bookmarks;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 23:19 2019/9/5
 */
public interface BookmarksService {

    public boolean addBookmarks(Bookmarks bookmarks) throws Exception;

    public boolean delBookmarks(int id) throws Exception;

    public boolean delBookmarksByName(String bookmarksName)throws Exception;

    public List<Bookmarks> listBookmarks() throws Exception;

    public List<Bookmarks> queryBookmarks(String bookmarksName) throws Exception;

    public boolean updateBookmarks(int id,String bookmarksName) throws Exception;

    public boolean addBlogId(String bookmarksName,String blogId)throws Exception;

    public Bookmarks queryBlogId(String bookmarksName)throws Exception;
}

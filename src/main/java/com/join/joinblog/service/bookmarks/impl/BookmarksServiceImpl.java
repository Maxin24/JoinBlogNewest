package com.join.joinblog.service.bookmarks.impl;

import com.join.joinblog.entity.bookmarks.Bookmarks;
import com.join.joinblog.mapper.bookmarks.BookmarksMapper;
import com.join.joinblog.service.bookmarks.BookmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 23:20 2019/9/5
 */
@Service
public class BookmarksServiceImpl implements BookmarksService {

    @Autowired
    BookmarksMapper bookmarksMapper;

    @Override
    public boolean addBookmarks(Bookmarks bookmarks) throws Exception{
        return bookmarksMapper.addBookmarks(bookmarks);
    }

    @Override
    public boolean delBookmarks(int id) throws Exception{
        return bookmarksMapper.delBookmarks(id);
    }

    @Override
    public boolean delBookmarksByName(String bookmarksName)throws Exception{
        return bookmarksMapper.delBookmarksByName(bookmarksName);
    }

    @Override
    public List<Bookmarks> listBookmarks() throws Exception{
        List<Bookmarks> list = Collections.emptyList();
        list = bookmarksMapper.listBookmarks();
        return list;
    }

    @Override
    public List<Bookmarks> queryBookmarks(String bookmarksName) throws Exception{
        List<Bookmarks> list1 = Collections.emptyList();
        list1 = bookmarksMapper.queryBookmarks(bookmarksName);
        return list1;
    }

    @Override
    public boolean updateBookmarks(int id,String bookmarksName) throws Exception{
        return bookmarksMapper.updateBookmarks(id,bookmarksName);
    }

    @Override
    public boolean addBlogId(String bookmarksName,String blogId)throws Exception{
        return bookmarksMapper.addBlogId(bookmarksName,blogId);
    }

    @Override
    public Bookmarks queryBlogId(String bookmarksName)throws Exception{
        return bookmarksMapper.queryBlogId(bookmarksName);
    }
}

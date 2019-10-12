package com.join.joinblog.controller.bookmarks;

import com.join.joinblog.entity.bookmarks.Bookmarks;
import com.join.joinblog.service.bookmarks.BookmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 11:05 2019/9/6
 */
@RestController
@CrossOrigin
@RequestMapping("/bookmarks")
public class BookmarksController {

    @Autowired
    BookmarksService bookmarksService;

    @RequestMapping(value = "/hello")
    public String say(){
        return "hello test";
    }

    @RequestMapping(value = "/add")
    public void addBookmarks(String bookmarksName) throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName(bookmarksName);
        bookmarksService.addBookmarks(bookmarks);
    }

    @RequestMapping(value = "/delById")
    public void delBookmarks(int id)throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setId(id);
        bookmarksService.delBookmarks(id);
    }

    @RequestMapping(value = "/del")
    public void delBookmarksByName(String bookmarksName)throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName(bookmarksName);
        bookmarksService.delBookmarksByName(bookmarksName);
    }

    @RequestMapping(value = "/list")
    public List<Bookmarks> listBookmarks() throws Exception{
        List<Bookmarks> list = bookmarksService.listBookmarks();
        return list;
    }

    @RequestMapping(value = "/query")
    public List<Bookmarks> queryBookmarks(String bookmarksName) throws Exception{
        List<Bookmarks> list1 = bookmarksService.queryBookmarks(bookmarksName);
        return list1;
    }

    @RequestMapping(value = "/update")
    public void updateBookmarks(int id,String bookmarksName) throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setId(id);
        bookmarks.setBookmarksName(bookmarksName);
        bookmarksService.updateBookmarks(id,bookmarksName);
    }

    @RequestMapping(value = "addId")
    public void addBlogId(String bookmarksName,String blogId) throws Exception{
        Bookmarks bookmarks = bookmarksService.queryBlogId(bookmarksName);
        bookmarksService.addBlogId(bookmarksName,bookmarks.getBlogId()+blogId+",");
    }


}

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
@CrossOrigin
@RestController
@RequestMapping("/bookmarks")
public class BookmarksController {

    @Autowired
    BookmarksService bookmarksService;

    @RequestMapping(value = "/hello")
    public String say(){
        return "hello test";
    }

    @RequestMapping(value = "/add")
    public boolean addBookmarks(String bookmarksName,String description,String userId) throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName(bookmarksName);
        bookmarks.setDescription(description);
        bookmarks.setUserId(userId);
        return bookmarksService.addBookmarks(bookmarks);
    }

    @RequestMapping(value = "/delById")
    public boolean delBookmarks(int id)throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setId(id);
        return bookmarksService.delBookmarks(id);
    }

    @RequestMapping(value = "/del")
    public boolean delBookmarksByName(String bookmarksName)throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName(bookmarksName);
        return bookmarksService.delBookmarksByName(bookmarksName);
    }

    @RequestMapping(value = "/listAll")
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
    public boolean updateBookmarks(int id,String bookmarksName) throws Exception{
        return bookmarksService.updateBookmarks(id,bookmarksName);
    }

    @RequestMapping(value = "addBlog")
    public boolean addBlog(String bookmarksName,String blogId,String blogName,String userId) throws Exception{
        return bookmarksService.addBlog(blogId,bookmarksName,blogName,userId);

    }

    @RequestMapping(value = "listName")
    public List<Bookmarks> listByName(String userId) throws Exception{
        List<Bookmarks> list1 = bookmarksService.listByName(userId);
        return list1;
    }

    @RequestMapping(value = "delAllBlog")
    public boolean delAllBlog(String bookmarksName) throws  Exception{
        Bookmarks bookmarks = new Bookmarks();
        return bookmarksService.delAllBlog(bookmarksName);
    }

    @RequestMapping(value = "listBlog")
    public List<Bookmarks> listBlogName(String bookmarksName) throws Exception{
        return bookmarksService.listBlogName(bookmarksName);
    }

    @RequestMapping(value = "isDo")
    public boolean isDo(String blogId,String userId) throws Exception{
        List<Bookmarks> list=bookmarksService.isDo(blogId,userId);
        System.out.println(list);
        if(list.isEmpty()){
            System.out.println("false");
            return false;
        }

        else{
            System.out.println("true");
            return true;
        }

    }

    @RequestMapping(value = "cancel")
    public boolean cancel(String blogId,String userId)throws Exception{
        return bookmarksService.cancel(blogId,userId);
    }


}

package com.join.joinblog.test;

import com.join.joinblog.BookmarksApplication;
import com.join.joinblog.entity.bookmarks.Bookmarks;
import com.join.joinblog.service.bookmarks.BookmarksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 23:51 2019/9/5
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmarksApplication.class)
public class BookmarksServiceTest {

    @Autowired
    BookmarksService bookmarksService;

    @Test
    public void testAddBookmarks() throws Exception{

            Bookmarks bookmarks = new Bookmarks();
            bookmarks.setBookmarksName("first");
            System.out.println(bookmarksService.addBookmarks(bookmarks));

    }

    @Test
    public void testDelBookmarks() throws Exception{

        Bookmarks bookmarks1 = new Bookmarks();
        bookmarks1.setId(1);
        System.out.println(bookmarksService.delBookmarks(bookmarks1.getId()));
    }

    @Test
    public void testDelBookmarksByName() throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName("e");
        System.out.println(bookmarksService.delBookmarksByName(bookmarks.getBookmarksName()));
    }

    @Test
    public void testListBookmarks() throws Exception{
        System.out.println(bookmarksService.listBookmarks());
    }

    @Test
    public void testQueryBookmarks() throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBookmarksName("a");
        System.out.println(bookmarksService.queryBookmarks(bookmarks.getBookmarksName()));
    }

    @Test
    public void testUpdateBookmarks() throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setId(5);
        bookmarks.setBookmarksName("try");
        System.out.println(bookmarksService.updateBookmarks(bookmarks.getId(),bookmarks.getBookmarksName()));
    }

    @Test
    //test方法不能带参数
    public void testAddBlogId() throws Exception{
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setBlogId("5,");
        bookmarks.setBookmarksName("test");
        System.out.println(bookmarksService.addBlogId(bookmarks.getBookmarksName(),bookmarks.getBlogId()));

    }

}

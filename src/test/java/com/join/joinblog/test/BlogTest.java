package com.join.joinblog.test;

import com.join.joinblog.BookmarksApplication;
import com.join.joinblog.service.blog.impl.BlogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:ljx
 * @Date:2019/9/23
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmarksApplication.class)
public class BlogTest {
    @Autowired
    BlogServiceImpl blogService;

    @Test
    public void testGetAllOrderByPv(){
        System.out.println(blogService.getAllOrderByPv());
    }

    @Test
    public void testGetAllOrderByDate(){
        System.out.println(blogService.getAllOrderByDate());
    }

    @Test
    public void testGetSomeOrderByPv(){
        System.out.println(blogService.getSomeOrderByPv(1));
    }

    @Test
    public void testGetSomeOrderByDate(){
        System.out.println(blogService.getSomeOrderByDate(3));
    }

//    @Test
//    public void testDeleteById(){
//        System.out.println(blogService.deleteById(122));
//    }

    @Test
    public void testFuzzyQuery(){
        System.out.println(blogService.fuzzyQueryByBLoggerNameOrTitle("java"));
    }

    @Test
    public void testUpdateUrl(){
        System.out.println(blogService.updateHtmlUrlById("1",115));
        System.out.println(blogService.updateMdUrlById("1",115));
    }


    @Test
    public void add(){
        for(int i=0;i<3;i++)
            blogService.addBLog(2,"杨岚清啥也传不过来","ylq");
    }

    @Test
    public void testAddPv(){
        blogService.updatePvById(120);
    }
}

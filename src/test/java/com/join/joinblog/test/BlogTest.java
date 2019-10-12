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
    public void testFuzzyQueryByTitle() {
        System.out.println(blogService.fuzzyQueryByTitle("的"));
    }

    @Test
    public void testUpdateTitleById(){
        blogService.updateTitleById("挪威的森林",1);
        System.out.println(blogService.fuzzyQueryByTitle("的"));
    }

    @Test
    public void testAddBlog(){
        for(int i=0;i<20;i++){
            blogService.addBLog(1,"Java SE 基础","ljx");
        }

    }

    @Test
    public void testQueryById(){
        System.out.println(blogService.queryById(0));
    }

    @Test
    public void testQueryByBloggerId(){
        System.out.println(blogService.queryByBloggerId(1));
    }

    @Test
    public void testQueryAll(){
        System.out.println(blogService.queryAll());
    }


    @Test
    public void testUpdateCommentsIdById(){
        blogService.updateCommentsIdById("100",1);
    }

    @Test
    public void testUpdateTagsById(){
        blogService.updateTagsById("java",1);
    }

    @Test
    public void testDeleteById(){
        blogService.deleteById(2);
    }
}

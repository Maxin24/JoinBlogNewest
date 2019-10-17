package com.join.joinblog.test;

import com.join.joinblog.BookmarksApplication;
import com.join.joinblog.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmarksApplication.class)
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void test()throws Exception{
        System.out.println(userService.queryUser(17));
    }


}


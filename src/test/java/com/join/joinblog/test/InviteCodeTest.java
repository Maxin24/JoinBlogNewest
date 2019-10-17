package com.join.joinblog.test;

import com.join.joinblog.BookmarksApplication;
import com.join.joinblog.entity.invitecode.InviteCode;
import com.join.joinblog.service.invitecode.impl.InviteCodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmarksApplication.class)
public class InviteCodeTest {
    @Autowired
    InviteCodeServiceImpl inviteCodeService;

    @Test
    public void testAddCode(){
        System.out.println(inviteCodeService.addCode(new InviteCode().getCode()));
        System.out.println(inviteCodeService.addCode(new InviteCode().getCode()));
    }

    @Test
    public void testGetCodes(){
        System.out.println(inviteCodeService.getCodes());
    }

    @Test
    public void testDeleteCode(){
        System.out.println(inviteCodeService.deleteCode("1"));
    }
}

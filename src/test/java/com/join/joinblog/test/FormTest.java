package com.join.joinblog.test;

import com.join.joinblog.BookmarksApplication;
import com.join.joinblog.entity.form.Form;
import com.join.joinblog.service.form.FormService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Nies
 * @Description:
 * @Date: 13:08 2019/10/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmarksApplication.class)
public class FormTest {
    @Autowired
    FormService formService;

    @Test
    public void testAddForm() throws Exception{
        Form form = new Form();
        form.setAge(5);
        form.setCollege("nenu");
        form.setDepartment("se");
        form.setGrade("2018");
        form.setIntroduce("myname");
        form.setMail("1611777@qq");
        form.setMajor("ssss");
        form.setPhone("1278749817971");
        form.setRank1(12);
        form.setRank2(120);
        form.setQQ("1111111111");
        form.setName("sbkjshkj");
        System.out.println(formService.addForm(form));
    }
}

package com.join.joinblog.controller.form;

import com.join.joinblog.entity.form.Form;
import com.join.joinblog.service.form.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Nies
 * @Description:
 * @Date: 12:03 2019/10/13
 */
@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    FormService formService;

    @RequestMapping(value = "/addform")
    public boolean addForm(String name,int age,String department,String college,String major,String grade,int rank1,int rank2,String phone,String QQ,String mail,String introduce) throws Exception{
        Form form = new Form();
        form.setAge(age);
        form.setCollege(college);
        form.setDepartment(department);
        form.setGrade(grade);
        form.setIntroduce(introduce);
        form.setMail(mail);
        form.setMajor(major);
        form.setPhone(phone);
        form.setRank1(rank1);
        form.setRank2(rank2);
        form.setQQ(QQ);
        form.setName(name);
        return formService.addForm(form);
    }
}

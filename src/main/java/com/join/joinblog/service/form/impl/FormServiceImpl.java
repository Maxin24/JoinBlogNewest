package com.join.joinblog.service.form.impl;

import com.join.joinblog.entity.form.Form;
import com.join.joinblog.mapper.form.FormMapper;
import com.join.joinblog.service.form.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Nies
 * @Description:
 * @Date: 19:24 2019/10/12
 */
@Service
public class FormServiceImpl implements FormService {
    @Autowired
    FormMapper formMapper;
    @Override
    public boolean addForm(Form form) throws Exception{
        return formMapper.addForm(form);
    }
}

package com.join.joinblog.service.invitecode.impl;

import com.join.joinblog.mapper.invitecode.InviteCodeMapper;
import com.join.joinblog.service.invitecode.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteCodeServiceImpl implements InviteCodeService {
    @Autowired
    InviteCodeMapper inviteCodeMapper;
    @Override
    public boolean addCode(String code) {
        if(inviteCodeMapper.addCode(code)!=0)
            return true;
        return false;
    }

    @Override
    public List getCodes() {
        return inviteCodeMapper.getCodes();
    }

    @Override
    public boolean deleteCode(String code) {
        if(inviteCodeMapper.deleteCode(code)!=0)
            return true;
        return false;
    }
}

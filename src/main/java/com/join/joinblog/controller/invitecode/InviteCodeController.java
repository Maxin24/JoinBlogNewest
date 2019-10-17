package com.join.joinblog.controller.invitecode;

import com.join.joinblog.entity.invitecode.InviteCode;
import com.join.joinblog.service.invitecode.impl.InviteCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/code")
public class InviteCodeController {
    @Autowired
    private InviteCodeServiceImpl inviteCodeService;


    @RequestMapping("/getAll")
    public List getAllCodes(){
        return inviteCodeService.getCodes();
    }

    @RequestMapping("/add")
    public List addCodes(@RequestBody String json){
        String s[]=json.split("=");
        int size=Integer.parseInt(s[1]);
        for(int i=0;i<size;i++){
            inviteCodeService.addCode(new InviteCode().getCode());
        }
        return inviteCodeService.getCodes();
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody String str){
        return inviteCodeService.deleteCode(str);
    }
}

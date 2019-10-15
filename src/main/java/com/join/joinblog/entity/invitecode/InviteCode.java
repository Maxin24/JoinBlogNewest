package com.join.joinblog.entity.invitecode;

import java.util.Random;

public class InviteCode {
    private int id;
    private String code;
    public InviteCode(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        this.code=sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "InviteCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}

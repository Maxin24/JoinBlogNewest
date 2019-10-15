package com.join.joinblog.mapper.invitecode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InviteCodeMapper {
    public int addCode(@Param("code") String code);
    public List getCodes();
    public int deleteCode(@Param("id") int id);
}

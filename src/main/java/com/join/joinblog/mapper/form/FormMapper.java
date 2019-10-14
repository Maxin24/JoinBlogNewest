package com.join.joinblog.mapper.form;

import com.join.joinblog.entity.form.Form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Nies
 * @Description:
 * @Date: 19:23 2019/10/12
 */
@Repository
@Mapper
public interface FormMapper {
    boolean addForm(@Param("form") Form form) throws Exception;
}

package com.join.joinblog.mapper.util;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:dongml
 * @Description:
 * @Date:9:42 2019/10/13
 */
@Repository
@Mapper
public interface UtilMapper {
    String MultiFilesUploads(@RequestParam(value = "picfile", required = false) MultipartFile[] files);
}

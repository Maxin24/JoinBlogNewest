package com.join.joinblog.service.util.impl;

import com.join.joinblog.mapper.util.UtilMapper;
import com.join.joinblog.service.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:dongml
 * @Description:
 * @Date:9:43 2019/10/13
 */
@Service

public class UtilServiceImpl implements UtilService {
    @Autowired
    UtilMapper utilMapper;

    @Override
    public String MultiFilesUpload(@RequestParam(value = "picfile", required=false) MultipartFile[] files){
        return utilMapper.MultiFilesUploads(files);
    }

}

package com.join.joinblog.service.util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:dongml
 * @Description:
 * @Date:9:42 2019/10/13
 */
public interface UtilService {
    String MultiFilesUpload(@RequestParam(value = "picfile", required = false) MultipartFile[] files);
}

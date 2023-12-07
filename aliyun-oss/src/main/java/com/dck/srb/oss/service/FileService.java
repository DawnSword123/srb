package com.dck.srb.oss.service;

import java.io.InputStream;

/**
 * @author Dawn.yang
 * @date 2023/12/7 10:53
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String fileName);

    void removeFile(String url);
}

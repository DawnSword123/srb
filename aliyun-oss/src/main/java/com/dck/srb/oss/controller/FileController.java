package com.dck.srb.oss.controller;

import com.dck.common.exception.BusinessException;
import com.dck.common.result.ResponseEnum;
import com.dck.common.result.Result;
import com.dck.srb.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Dawn.yang
 * @date 2023/12/7 11:04
 */
@RestController
@Slf4j
@Api(tags = "阿里云文件管理")
//@CrossOrigin //跨域
@RequestMapping("/api/oss/file")
public class FileController {
    @Resource
    private FileService fileService;

    /**
     * 文件上传
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result upload(
            @ApiParam(value = "文件", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(value = "模块", required = true)
            @RequestParam("module") String module)  {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            log.info("文件上传成功,文件链接: {}",uploadUrl);
            //返回r对象
            return Result.ok().message("文件上传成功").data("url", uploadUrl);
        } catch (IOException e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @ApiOperation("删除OSS文件")
    @DeleteMapping("/remove")
    public Result remove(
            @ApiParam(value = "要删除的文件路径", required = true)
            @RequestParam("url") String url) {
        fileService.removeFile(url);
        log.info("文件链接: {},已删除",url);
        return Result.ok().message("删除成功");
    }
}

package com.myd.controller;

import ch.qos.logback.core.util.FileUtil;
import com.myd.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author myd
 * @date 2023/4/8  22:33
 */

@RestController
@Slf4j
public class UploadController {



    private static final String FILE_PACKAGE = "files";

    @RequestMapping("/upload/{meetingId}/{userId}")
    public Result<String> upload(
            @PathVariable("meetingId") String meetingId,
            @PathVariable("userId") String userId,
            HttpServletRequest request,
            @RequestParam("excel") MultipartFile multipartFile) throws FileNotFoundException {

        log.info("本文件的概要信息： -> {},name -> {}",multipartFile.getOriginalFilename(),multipartFile.getName());
        String path = request.getServletContext().getRealPath("/files/");
        path = new File(ResourceUtils.getURL("classPath:").getPath()).getAbsolutePath();
        log.info(path);
        String originalFilename = multipartFile.getOriginalFilename();
        File upload = new File(filePath(path,FILE_PACKAGE,meetingId,userId,originalFilename));
        //如果文件目录不存在就创建
        if(!upload.getParentFile().exists()){
            upload.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(upload);
            return Result.ok("操作成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail("操作失败！\n"+e.getMessage());
        }
    }

    @RequestMapping("/download/{meetingId}/{userId}")
    public ResponseEntity<byte[]> download(
            @PathVariable("meetingId")String meetingId,
            @PathVariable("userId")String userId,
            @RequestParam("fileName")String fileName,
            @RequestHeader("User-Agent")String userAgent
    ){

        //在talk_person_info表中，用meeting_id和user_id来查询excel；；；--> 没有必要，直接用file.
        try {
            String root = new File(ResourceUtils.getURL("classpath:").getPath()).getAbsolutePath();
            File excel = new File(filePath(root,FILE_PACKAGE,meetingId,userId,fileName));

            ResponseEntity.BodyBuilder builder = ResponseEntity.ok();

            builder.contentLength(excel.length());

            /**
             * 二进制数据流 application/octet-stream
             */
            builder.contentType(MediaType.APPLICATION_OCTET_STREAM);

            fileName = URLEncoder.encode(fileName,"UTF-8");

            if(userAgent.indexOf("MSIE") >  0){
                //IE浏览器
                builder.header("Content-Disposition","attachment; filename="+fileName);

            }else{
                //其他浏览器：firefox，Chrome，..
                builder.header("Content-Disposition","attachment; filename*=UTF-8''"+fileName);
            }
            return builder.body(FileUtils.readFileToByteArray(excel));

        }  catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage().getBytes());
        }





    }


    /**
     *
     *
     * @param root  项目根路径
     * @param filePackage 所有files的路径
     * @param meetingId 会议id
     * @param userId 用户的userId
     *
     * @return
     */
    public String fileParentPath(String root,String filePackage,String meetingId,String userId){
        return  root + File.separator + filePackage+ File.separator+meetingId + File.separator + userId ;
    }


    public String filePath(String root,String filePackage,String meetingId,String userId,String fileName){

        return root + File.separator + filePackage+ File.separator+meetingId + File.separator + userId +  File.separator + fileName;
    }




}

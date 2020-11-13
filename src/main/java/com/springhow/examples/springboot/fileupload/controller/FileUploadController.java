package com.springhow.examples.springboot.fileupload.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {


    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("myFile") MultipartFile multipartFile) throws IOException {
        multipartFile.transferTo(new File("C:\\data\\test\\" + multipartFile.getOriginalFilename()));
        return "success";
    }


    @RequestMapping(value = "/two-file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadTwoFile(@RequestParam("myFile") MultipartFile multipartFile, @RequestParam("myOtherFile") MultipartFile otherMultipartFile) throws IOException {
        multipartFile.transferTo(new File("C:\\data\\test\\" + multipartFile.getOriginalFilename()));
        otherMultipartFile.transferTo(new File("C:\\data\\test\\" + otherMultipartFile.getOriginalFilename()));
        return "success";
    }

    @RequestMapping(value = "/multiple-file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipleFiles(@RequestParam("myFiles") MultipartFile[] multipartFiles) throws IOException {
        for (MultipartFile multipartFile : multipartFiles) {
            multipartFile.transferTo(new File("C:\\data\\test\\" + multipartFile.getOriginalFilename()));
        }
        return "success";
    }
}

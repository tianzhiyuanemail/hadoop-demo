package com.example.controller;

import com.example.service.HdfsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping
@RestController
public class HController {

    @Resource
    private HdfsService hdfsService;

    @PostMapping("/createFile")
    public void createFile(@RequestParam("path") String path, @RequestParam("file") MultipartFile file)
            throws Exception {

        hdfsService.createFile(path, file);

    }

}
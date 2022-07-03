package com.example.community.controller;

import com.example.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload() {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/loading.gif");
        return fileDTO;
    }
}

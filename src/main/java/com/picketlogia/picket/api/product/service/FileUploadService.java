package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.api.product.utils.FileUploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//@Service
public class FileUploadService implements UploadService {
    @Override
    public String upload(MultipartFile file) throws IOException {
        String basePath = "c:\\upload\\";
        String dirPath = FileUploadUtil.makeUploadPath();
        String fileName = file.getOriginalFilename();
        File uploadFile = new File(basePath+dirPath + fileName);        // 파일 경로+날짜+원본파일명
        file.transferTo(uploadFile);
        return dirPath+fileName;
    }
}

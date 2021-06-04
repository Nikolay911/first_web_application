package com.mycompany.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
    private MultipartFile fileName;

    public MultipartFile getFile() {
        return fileName;
    }

    public void setFile(MultipartFile fileName) {
        this.fileName = fileName;
    }
}

package com.example.supplychainmanagement.utils;

import com.example.supplychainmanagement.entities.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public class Utils {


    public static Attachment saveFile(MultipartFile file, String path) throws IOException {

        if (!file.isEmpty()){
            String filePath = path + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            Attachment attachment = new Attachment();
            attachment.setAttachmentName(file.getOriginalFilename());
            attachment.setAttachmentPath(filePath);
            attachment.setAttachmentType(file.getContentType());
            return attachment;
        }else {
            return null;
        }
    }




}

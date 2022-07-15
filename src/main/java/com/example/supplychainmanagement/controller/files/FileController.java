package com.example.supplychainmanagement.controller.files;

import com.example.supplychainmanagement.entities.Attachment;
import com.example.supplychainmanagement.repositories.AttachmentRepo;
import com.example.supplychainmanagement.utils.Constant;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.Optional;

@Controller
@RequestMapping("/api/page/v1")
public class FileController {
    @Autowired
    private AttachmentRepo attachmentRepo;

    @GetMapping("/image-manual-response/{filename}")
    public void getImageAsByteArray(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
//        InputStream in = servletContext.getResourceAsStream(Constant.PRODUCT_UPLOAD_IMAGE_LOCATION +filename);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        IOUtils.copy(in, response.getOutputStream());

        Optional<Attachment> attachment = attachmentRepo.findById(Long.valueOf(filename));

        File file = new File(attachment.get().getAttachmentPath());
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}

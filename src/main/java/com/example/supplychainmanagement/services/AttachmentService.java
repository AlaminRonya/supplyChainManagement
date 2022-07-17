package com.example.supplychainmanagement.services;

import com.example.supplychainmanagement.entities.Attachment;
import com.example.supplychainmanagement.repositories.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentRepo attachmentRepo;

    public Attachment addAttachment(Attachment attachment){
        return insert(attachment);
    }

    private Attachment insert(Attachment attachment){
        return attachmentRepo.save(attachment);
    }

    private Attachment searchById(Long id){
        return attachmentRepo.findById(id).orElse(null);
    }

    public void updateAttachmentById(Long id, String attachmentName){
        attachmentRepo.updateAttachmentById(id, attachmentName);
    }
}

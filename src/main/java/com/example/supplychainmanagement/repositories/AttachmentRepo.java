package com.example.supplychainmanagement.repositories;

import com.example.supplychainmanagement.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional(readOnly = true)
public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Attachment a " +
            "SET a.attachmentName = ?2 WHERE a.id = ?1")
    int updateAttachmentById(Long id, String attachmentName);
}

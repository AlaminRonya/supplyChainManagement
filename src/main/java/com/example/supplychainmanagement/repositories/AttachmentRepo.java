package com.example.supplychainmanagement.repositories;

import com.example.supplychainmanagement.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
}

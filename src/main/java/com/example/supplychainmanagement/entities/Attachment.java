package com.example.supplychainmanagement.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "attachments")
public class Attachment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "attachment_name")
    private String attachmentName;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "attachment_type")
    private String attachmentType;


}

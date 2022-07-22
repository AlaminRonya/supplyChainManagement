package com.example.supplychainmanagement.entities.user;


import com.example.supplychainmanagement.entities.Attachment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "dealer")
@ToString
public class Dealer {
    @SequenceGenerator(
            name = "dealer_sequence",
            sequenceName = "dealer_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dealer_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private String phoneNumber;
    private Date dob;
    private String userNID;
    private String userBankAccountNumber;
    private String tradeLicenseNumber;
    private String gender;
    private Boolean active = false;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id_trade", referencedColumnName = "id")
    private Attachment tradeLicenseDocument;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id_profile", referencedColumnName = "id")
    private Attachment profilePhoto;


}

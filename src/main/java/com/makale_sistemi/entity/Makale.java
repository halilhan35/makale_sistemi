package com.makale_sistemi.entity;

import com.makale_sistemi.constant.SequenceConstants;
import com.makale_sistemi.constant.TableConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.MAKALE)
@SequenceGenerator(sequenceName = SequenceConstants.MAKALE_SEQ, name = TableConstants.MAKALE, allocationSize = 1)
public class Makale implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.MAKALE, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TAKIP_NUMARASI", unique = true, nullable = false, length = 20)
    private String takipNumarasi;

    @Column(name = "URL", nullable = false, length = 200)
    private String url;

    @Column(name = "MAKALE_ID", nullable = false)
    private Long makaleId;

    @Column(name = "YUKLEME_TARIHI", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date yuklemeTarihi;
}
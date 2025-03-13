package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name="makale")
public class Makale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "takip_numarasi", unique = true, nullable = false, length = 20)
    private String takipNumarasi;

    @Column(name = "url", nullable = false, length = 200)
    private String url;

    @Column(name = "makale_id", nullable = false)
    private long makaleId;

    @Column(name = "yukleme_tarihi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date yuklemeTarihi;

}
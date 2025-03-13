package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "degerlendirme")
public class Degerlendirme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "makale_id", nullable = false)
    private long makaleId;

    @Column(name = "yorum", nullable = false, columnDefinition = "TEXT")
    private String yorum;

    @Column(name = "degerlendirme_tarihi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date degerlendirmeTarihi;

}
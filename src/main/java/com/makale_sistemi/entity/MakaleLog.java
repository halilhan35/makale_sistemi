package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "makale_log")
public class MakaleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "makale_id", nullable = false)
    private long makaleId;

    @Column(name = "durum", nullable = false, length = 50)
    private String durum;

    @Column(name = "tarih", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarih;

}
package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "mesaj")
public class Mesaj {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

 @Column(name = "makale_id", nullable = false)
 private long makaleId;

 @Column(name = "gonderen", nullable = false, length = 20)
 private String gonderen;

 @Column(name = "mesaj", nullable = false, columnDefinition = "TEXT")
 private String mesaj;

 @Column(name = "tarih", nullable = false)
 @Temporal(TemporalType.TIMESTAMP)
 private Date tarih;

}
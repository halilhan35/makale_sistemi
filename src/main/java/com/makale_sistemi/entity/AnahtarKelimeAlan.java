package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "anahtar_kelime_alan")
public class AnahtarKelimeAlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "alan_id", nullable = false)
    private long alanId;

    @Column(name = "anahtar_kelime", nullable = false, length = 20)
    private String anahtarKelime;

}
package com.makale_sistemi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "makale_alan")
public class MakaleAlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "alan_id", nullable = false)
    private long alanId;

    @Column(name = "makale_id", nullable = false)
    private long makaleId;

}
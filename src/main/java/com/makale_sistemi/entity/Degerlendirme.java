package com.makale_sistemi.entity;

import com.makale_sistemi.constant.SequenceConstants;
import com.makale_sistemi.constant.TableConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.DEGERLENDIRME)
@SequenceGenerator(sequenceName = SequenceConstants.DEGERLENDIRME_SEQ, name = TableConstants.DEGERLENDIRME, allocationSize = 1)
public class Degerlendirme implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.DEGERLENDIRME, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "MAKALE_ID", nullable = false)
    private Long makaleId;

    @Column(name = "YORUM", nullable = false, columnDefinition = "TEXT")
    private String yorum;

    @Column(name = "DEGERLENDIRME_TARIHI", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime degerlendirmeTarihi;
}
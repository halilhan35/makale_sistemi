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
@Table(name = TableConstants.MAKALE_LOG)
@SequenceGenerator(sequenceName = SequenceConstants.MAKALE_LOG_SEQ, name = TableConstants.MAKALE_LOG, allocationSize = 1)
public class MakaleLog implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.MAKALE_LOG, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "MAKALE_ID", nullable = false)
    private Long makaleId;

    @Column(name = "DURUM", nullable = false, length = 50)
    private String durum;

    @Column(name = "TARIH", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime tarih;
}
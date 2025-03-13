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
@Table(name = TableConstants.MESAJ)
@SequenceGenerator(sequenceName = SequenceConstants.MESAJ_SEQ, name = TableConstants.MESAJ, allocationSize = 1)
public class Mesaj implements Serializable {

 @Id
 @Column(name = "ID", nullable = false)
 @GeneratedValue(generator = TableConstants.MESAJ, strategy = GenerationType.SEQUENCE)
 private Long id;

 @Column(name = "MAKALE_ID", nullable = false)
 private Long makaleId;

 @Column(name = "GONDEREN", nullable = false, length = 20)
 private String gonderen;

 @Column(name = "MESAJ", nullable = false, columnDefinition = "TEXT")
 private String mesaj;

 @Column(name = "TARIH", nullable = false)
 @Temporal(TemporalType.TIMESTAMP)
 private LocalDateTime tarih;
}
package com.makale_sistemi.entity;

import com.makale_sistemi.constant.SequenceConstants;
import com.makale_sistemi.constant.TableConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.ANAHTAR_KELIME_ALAN)
@SequenceGenerator(sequenceName = SequenceConstants.ANAHTAR_KELIME_ALAN_SEQ, name = TableConstants.ANAHTAR_KELIME_ALAN, allocationSize = 1)
public class AnahtarKelimeAlan implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.ANAHTAR_KELIME_ALAN, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ALAN_ID", nullable = false)
    private Long alanId;

    @Column(name = "ANAHTAR_KELIME", nullable = false, length = 20)
    private String anahtarKelime;
}
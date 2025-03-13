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
@Table(name = TableConstants.MAKALE_ALAN)
@SequenceGenerator(sequenceName = SequenceConstants.MAKALE_ALAN_SEQ, name = TableConstants.MAKALE_ALAN, allocationSize = 1)
public class MakaleAlan implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.MAKALE_ALAN, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ALAN_ID", nullable = false)
    private Long alanId;

    @Column(name = "MAKALE_ID", nullable = false)
    private Long makaleId;
}
package com.makale_sistemi.entity;

import com.makale_sistemi.constant.SequenceConstants;
import com.makale_sistemi.constant.TableConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.ALAN)
@SequenceGenerator(sequenceName = SequenceConstants.ALAN_SEQ, name = TableConstants.ALAN, allocationSize = 1)
public class Alan {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = TableConstants.ALAN, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "AD", nullable = false)
    private String ad;
}
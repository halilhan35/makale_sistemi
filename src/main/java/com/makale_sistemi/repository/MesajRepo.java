package com.makale_sistemi.repository;

import com.makale_sistemi.entity.Mesaj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesajRepo extends JpaRepository<Mesaj,Long> {
}

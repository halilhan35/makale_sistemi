package com.makale_sistemi.repository;

import com.makale_sistemi.entity.Alan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlanRepository extends JpaRepository<Alan, Long> {
}
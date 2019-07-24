package com.haseong.demo.repository;

import com.haseong.demo.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesTopRepository extends JpaRepository<Clothes.TopEntity, String> {
}

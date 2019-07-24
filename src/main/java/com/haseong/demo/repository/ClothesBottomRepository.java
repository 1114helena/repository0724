package com.haseong.demo.repository;

import com.haseong.demo.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesBottomRepository extends JpaRepository<Clothes.BottomEntity, String> {
}

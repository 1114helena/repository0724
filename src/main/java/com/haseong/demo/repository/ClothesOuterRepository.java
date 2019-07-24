package com.haseong.demo.repository;

import com.haseong.demo.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesOuterRepository extends JpaRepository<Clothes.OuterEntity, String> {
}

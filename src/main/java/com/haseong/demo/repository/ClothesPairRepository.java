package com.haseong.demo.repository;

import com.haseong.demo.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesPairRepository extends JpaRepository<Clothes.PairEntity, String> {
}

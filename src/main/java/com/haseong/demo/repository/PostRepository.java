package com.haseong.demo.repository;

import com.haseong.demo.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

  //Optional<PostEntity> findByMemberId(Pageable pageable, Integer MemberId);
  //Page<PostEntity> findByMemberId(Integer memberId, Pageable pageable);
  Page<PostEntity> findByProviderUserId(String providerUserId, Pageable pageable);
  //Optional<PostEntity> findByProviderUserId(Pageable pageable, String providerUserId);
}

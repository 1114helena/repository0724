package com.haseong.demo.repository;

import com.haseong.demo.entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * public interface PostLikeRepository extends JpaRepository<PostLikeEntity, Integer> {
    Optional<PostLikeEntity> findByMemberIdAndPostId(Integer memberId, Integer postId);
    }
 **/

public interface PostLikeRepository extends JpaRepository<PostLikeEntity, String> {
    //Optional<PostLikeEntity> findByMemberIdAndPostId(Integer memberId, Integer postId);
    Optional<PostLikeEntity> findByProviderUserIdAndPostId(String providerUserId, Integer postId);
    List<PostLikeEntity> findByPostId(Integer postId);
}
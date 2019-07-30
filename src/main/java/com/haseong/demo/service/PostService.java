package com.haseong.demo.service;

import com.haseong.demo.dto.PostRequest;
import com.haseong.demo.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostEntity createPost(String fileUrl, String providerUserId, PostRequest postRequest);

    //내가 추가한 것.. providerUserId때문
    //PostEntity getProviderUserId(String providerUserId);

    List<PostEntity> getPosts(Pageable pageable);

    //PostEntity likePost(Integer memberId, Integer postId);
    PostEntity likePost(String providerUserId, Integer postId);

    //PostEntity unlikePost(Integer memberId, Integer postId);
    PostEntity unlikePost(String providerUserId, Integer postId);

    //PostEntity salePost(Integer memberId, Integer postId);
    //PostEntity salePost(String providerUserId, Integer postId);

    //PostEntity nosalePost(Integer memberId, Integer postId);
    //PostEntity nosalePost(String providerUserId, Integer postId);

    List<PostEntity> recommendPosts(String providerUserId);

    //Page<PostEntity> myfeeds(Pageable pageable, Integer memberId);
    Page<PostEntity> myfeeds(Pageable pageable, String providerUserId);

    PostEntity modifyPost(Integer postId, PostRequest postEntity);
}

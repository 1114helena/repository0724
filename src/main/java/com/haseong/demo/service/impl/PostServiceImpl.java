package com.haseong.demo.service.impl;

import com.haseong.demo.dto.PostRequest;
import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.entity.PostEntity;
import com.haseong.demo.entity.PostLikeEntity;
import com.haseong.demo.exception.ApiFailedException;
import com.haseong.demo.repository.MemberRepository;
import com.haseong.demo.repository.PostLikeRepository;
import com.haseong.demo.repository.PostRepository;
import com.haseong.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final PostLikeRepository postLikeRepository;

    @Override
    @Transactional
    public PostEntity createPost(String fileDownloadUri, String providerUserId, PostRequest postRequest) {
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId).orElseThrow(()-> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."));
        PostEntity postEntity = new PostEntity();
        postEntity.setProviderUserId(providerUserId);
        postEntity.setMemberId(memberEntity.getMemberId());
        postEntity.setCount(0);
        postEntity.setDong(postRequest.getDong());
        postEntity.setCost(postRequest.getCost());
        postEntity.setTitle(postRequest.getTitle());
        postEntity.setDescription(postRequest.getDescription());
        postEntity.setSale(Boolean.TRUE);
        postEntity.setImageUrl(fileDownloadUri);
        postEntity.setCategoryA(postRequest.getCategoryA());
        postEntity.setCategoryB(postRequest.getCategoryB());
//        postEntity.setCombiId(postRequest.getCombiId());
//        postEntity.setTempId(postRequest.getTempId());
//        postEntity.setTopClothesId(postRequest.getTopClothesId());
//        postEntity.setBottomClothesId(postRequest.getBottomClothesId());
//        postEntity.setPairClothesId(postRequest.getPairClothesId());
//        postEntity.setOuterClothesId(postRequest.getOuterClothesId());
        return postRepository.save(postEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostEntity> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable).getContent();
    }
/**
    @Override
    @Transactional
    //public PostEntity salePost(Integer memberId, Integer postId) {
    public PostEntity salePost(String providerUserId, Integer postId) {
        //MemberEntity memberEntity = memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //MemberEntity memberEntity = memberRepository.findById(providerUserId)
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."));

        if (postLikeRepository.findByProviderUserIdAndPostId(providerUserId, postId).isPresent()) {
            return postEntity;
        }

        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setProviderUserId(providerUserId);
        saleEntity.setSaleId(postId);
        saleRepository.save(saleEntity);

        postEntity.onSale();
        return postEntity;
    }

    @Override
    @Transactional
    //public PostEntity nosalePost(Integer memberId, Integer postId) {
    public PostEntity nosalePost(String providerUserId, Integer postId) {
        //MemberEntity memberEntity = memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //MemberEntity memberEntity = memberRepository.findById(providerUserId)
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."));

        SaleEntity saleEntity = saleRepository.findByProviderUserIdAndPostId(providerUserId, postId).orElse(null);
        if (saleEntity == null) {
            return postEntity;
        }

        saleRepository.delete(saleEntity);
        postEntity.noSale();

        return postEntity;
    }
**/
    /**
     *
     * 좋아요or좋아요취소
     */
    @Override
    @Transactional
    //public PostEntity likePost(Integer memberId, Integer postId) {
    public PostEntity likePost(String providerUserId, Integer postId) {
        //MemberEntity memberEntity = memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //MemberEntity memberEntity = memberRepository.findById(providerUserId)
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."));

        if (postLikeRepository.findByProviderUserIdAndPostId(providerUserId, postId).isPresent()) {
            return postEntity;
        }

        PostLikeEntity postLikeEntity = new PostLikeEntity();
        //postLikeEntity.setMemberId(memberId);
        postLikeEntity.setProviderUserId(providerUserId);
        postLikeEntity.setPostId(postId);
        postLikeRepository.save(postLikeEntity);

        postEntity.addCount();
        return postEntity;
    }

    @Override
    @Transactional
    //public PostEntity unlikePost(Integer memberId, Integer postId) {
    public PostEntity unlikePost(String providerUserId, Integer postId) {
        //MemberEntity memberEntity = memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //MemberEntity memberEntity = memberRepository.findById(providerUserId)
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."));

        PostLikeEntity postLikeEntity = postLikeRepository.findByProviderUserIdAndPostId(providerUserId, postId).orElse(null);
        if (postLikeEntity == null) {
            return postEntity;
        }

        postLikeRepository.delete(postLikeEntity);
        postEntity.subCount();

        return postEntity;
    }

    @Override
    public Integer[] likedPostsByUser(String providerUserId){
        List<PostEntity> posts = postRepository.findAll();

        return posts.stream().filter(
            postEntity -> {
                PostLikeEntity postLikeEntity = postLikeRepository.findByProviderUserIdAndPostId(providerUserId, postEntity.getPostId()).orElse(null);
                return postLikeEntity != null;
            }
        ).map(postEntity -> { return postEntity.getPostId(); })
            .toArray(Integer[]::new);
    }

  @Override
  public Optional<PostEntity> getPopularPost(String category) {
        Optional<PostEntity> entity = postRepository.findAll().stream().filter(it -> { return it.getCategoryA() == category; })
            .sorted((param1, param2) -> {
                List<PostLikeEntity> l1 = postLikeRepository.findByPostId(param1.getPostId());
                List<PostLikeEntity> l2 = postLikeRepository.findByPostId(param2.getPostId());
                return l1.size() - l2.size();
            }).findFirst();
    return entity;
  }

  @Override
    @Transactional(readOnly = true)
    //public List<PostEntity> recommendPosts(Integer memberId) {
    public List<PostEntity> recommendPosts(String providerUserId) {
        //MemberEntity memberEntity = memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //MemberEntity memberEntity = memberRepository.findById(providerUserId)
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        List<PostEntity> postEntities = postRepository.findAll();
        Collections.shuffle(postEntities);
        int index = Integer.min(postEntities.size(), 5);
        return postEntities.subList(0, index);
    }

    @Override
    @Transactional(readOnly = true)
    //public Page<PostEntity> myfeeds(Pageable pageable, Integer memberId) {
    public Page<PostEntity> myfeeds(Pageable pageable, String providerUserId) {
        //memberRepository.findById(memberId)
        //여기도 그런지?
        //memberRepository.findById(providerUserId)
        memberRepository.findByProviderUserId(providerUserId)
            .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "member not found"));

        //return postRepository.findByMemberId(memberId, pageable);
        return postRepository.findByProviderUserId(providerUserId, pageable);
    }

    @Override
    public PostEntity modifyPost(Integer postId, PostRequest postRequest) {
        PostEntity entity = postRepository.findById(postId).orElseThrow(()-> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시물을 찾을 수 없습니다."));
        PostEntity postEntity = entity;
        postEntity.setProviderUserId(entity.getProviderUserId());
        //postEntity.setMemberId(memberId);
        postEntity.setCount(entity.getCount());
        postEntity.setPostId(entity.getPostId());
        postEntity.setImageUrl(entity.getImageUrl());
        postEntity.setCreatedAt(entity.getCreatedAt());
        postEntity.setUpdatedAt(LocalDateTime.now());
        postEntity.setDong(postRequest.getDong());
        postEntity.setCost(postRequest.getCost());
        postEntity.setTitle(postRequest.getTitle());
        postEntity.setDescription(postRequest.getDescription());
        postEntity.setSale(postRequest.getSale());
        //postEntity.setImageUrl(postRequest.getImageUrl());
        postEntity.setCategoryA(postRequest.getCategoryA());
        postEntity.setCategoryB(postRequest.getCategoryB());
        postRepository.save(postEntity);
        return postEntity;
    }

    @Override
    @Transactional
    public PostEntity deletePost(String providerUserId, Integer postId) {
        MemberEntity memberEntity = memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."));
        postRepository.delete(postEntity);
        return postEntity;
    }

}

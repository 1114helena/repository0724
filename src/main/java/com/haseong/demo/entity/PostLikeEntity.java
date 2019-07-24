package com.haseong.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PostLikeEntity")
@Data
public class PostLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_like_id")
    private Integer postLikeId;

    /**
     * @Column(name = "member_id")
    private Integer memberId;
    **/

    @Column(name = "provider_user_id")
    private String providerUserId;

    @Column(name = "post_id")
    private Integer postId;


    public Integer getPostLikeId() {
        return postLikeId;
    }

    public void setPostLikeId(Integer postLikeId) {
        this.postLikeId = postLikeId;
    }
/**
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
**/

    public String getProviderUserId() {
    return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}

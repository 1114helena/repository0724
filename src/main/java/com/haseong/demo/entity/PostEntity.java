package com.haseong.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
@EntityListeners(AuditingEntityListener.class)
public class PostEntity {
    /**
     * 글 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Integer postId;

    /**
     * 글쓴사람 아이디
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 인증 제공자에서 사용하는 아이디
     * */
    @Column(name = "provider_user_id")
    private String providerUserId;

    /**
     * 생성 시간
     */
    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * 수정 시간
     */
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * 콤비 아이디
     */
    //@Column(name = "combi_id")
    //private String combiId;

    /**
     * 온도 아이디
     */
    //@Column(name = "temp_id")
    //private String tempId;

    /**
     * 동
     */
    @Column(name = "dong")
    private String dong;

    /**
     * 가격
     */
    @Column(name = "cost")
    private String cost;

    /**
     * 글 제목
     */
    @Column(name = "title")
    private String title;


    /**
     * 글 본문
     */
    @Column(name = "description")
    private String description;

    /**
     * 이미지 주소
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 좋아요 개수
     */
    @Column(name = "count")
    private Integer count;
    public void addCount() {
        count += 1;
    }
    public void subCount() {
        count -= 1;
    }

    /**
     * 판매중or판매완료
     */
    @Column(name = "sale")
    private Boolean sale;
    public void onSale() { sale = Boolean.TRUE; }
    public void noSale() {
        sale = Boolean.FALSE;
    }

    /**
     * 카테고리 A
     */
    @Column(name = "categoryA")
    private String categoryA;

    /**
     * 카테고리 B
     */
    @Column(name = "categoryB")
    private String categoryB;


//    @Column(name = "t_clothes_id")
//    private String topClothesId;
//
//    @Column(name = "b_clothes_id")
//    private String bottomClothesId;
//
//    @Column(name = "p_clothes_id")
//    private String pairClothesId;
//
//    @Column(name = "o_clothes_id")
//    private String outerClothesId;



    /////
//    public Integer getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Integer postId) {
//        this.postId = postId;
//    }
//
//    public Integer getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Integer memberId) {
//        this.memberId = memberId;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getCombiId() {
//        return combiId;
//    }
//
//    public void setCombiId(String combiId) {
//        this.combiId = combiId;
//    }
//
//    public String getTempId() {
//        return tempId;
//    }
//
//    public void setTempId(String tempId) {
//        this.tempId = tempId;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public String getTopClothesId() {
//        return topClothesId;
//    }
//
//    public void setTopClothesId(String topClothesId) {
//        this.topClothesId = topClothesId;
//    }
//
//    public String getBottomClothesId() {
//        return bottomClothesId;
//    }
//
//    public void setBottomClothesId(String bottomClothesId) {
//        this.bottomClothesId = bottomClothesId;
//    }
//
//    public String getPairClothesId() {
//        return pairClothesId;
//    }
//
//    public void setPairClothesId(String pairClothesId) {
//        this.pairClothesId = pairClothesId;
//    }
//
//    public String getOuterClothesId() {
//        return outerClothesId;
//    }
//
//    public void setOuterClothesId(String outerClothesId) {
//        this.outerClothesId = outerClothesId;
//    }
}

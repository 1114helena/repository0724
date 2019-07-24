package com.haseong.demo.dto;

import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.entity.PostEntity;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class PostResponse {

    /**
     * 글 id
     */
    private Integer id;

    /**
     * 글쓴사람
     */
    private MemberResponse member;

    /**
     * 좋아요 개수
     */
    private Integer count;

    /**
     * 생성 시간
     */
    private LocalDateTime createdAt;
    /**
     * 마지막 수정 시간
     */
    private LocalDateTime updatedAt;

    /**
     * 동
     */
    private String dong;

    /**
     * 가격
     */
    private String cost;

    /**
     * 글 제목
     */
    private String title;

    /**
     * 글 본문
     */
    private String description;

    /**
     * 판매중or판매완료
     */
    private Boolean sale;

    /**
     * 이미지 주소
     */
    private String imageUrl;

    /**
     * 카테고리 A
     */
    private String categoryA;

    /**
     * 카테고리 B
     */
    private String categoryB;

    /**
    * 콤비 아이디
    */
    //private String combiId;

    /**
     * 온도 아이디
     */
    //private String tempId;

    /** 상의 */
    //private String topClothesId;

    /** 하의 */
    //private String bottomClothesId;

    /** 상의/하의 */
    //private String pairClothesId;

    /** 외투 */
    //private String outerClothesId;


    public static PostResponse of(PostEntity postEntity, MemberEntity memberEntity) {
        PostResponse postResponse = new PostResponse();
        postResponse.id = postEntity.getPostId();
        postResponse.member = MemberResponse.from(memberEntity);
        postResponse.count = postEntity.getCount();
        postResponse.createdAt = postEntity.getCreatedAt();
        postResponse.updatedAt = postEntity.getUpdatedAt();
        postResponse.dong = postEntity.getDong();
        postResponse.cost = postEntity.getCost();
        postResponse.title = postEntity.getTitle();
        postResponse.description = postEntity.getDescription();
        postResponse.sale = postEntity.getSale();
        postResponse.imageUrl = postEntity.getImageUrl();
        postResponse.categoryA = postEntity.getCategoryA();
        postResponse.categoryB = postEntity.getCategoryB();
        //postResponse.combiId = postEntity.getCombiId();
        //postResponse.tempId = postEntity.getTempId();
        //postResponse.topClothesId = postEntity.getTopClothesId();
        //postResponse.bottomClothesId = postEntity.getBottomClothesId();
        //postResponse.pairClothesId = postEntity.getPairClothesId();
        //postResponse.outerClothesId = postEntity.getOuterClothesId();
        //postResponse.providerUserId = MemberResponse.from(memberEntity);
        return postResponse;
    }

//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberResponse getMember() {
        return member;
    }

    public void setMember(MemberResponse member) {
        this.member = member;
    }

    public Integer getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // puid 추가
//    public MemberResponse getProviderUserId() {
//        return providerUserId;
//    }
//    public void setProviderUserId(MemberResponse providerUserId) {
//        this.providerUserId = providerUserId;
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
    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSale() { return sale; }

    public void setSale(Boolean sale) { this.sale = sale; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryA() {
        return categoryA;
    }

    public void setCategoryA(String categoryA) {
        this.categoryA = categoryA;
    }

    public String getCategoryB() {
        return categoryB;
    }

    public void setCategoryB(String categoryB) {
        this.categoryB = categoryB;
    }

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

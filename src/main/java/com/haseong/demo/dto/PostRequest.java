package com.haseong.demo.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

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
     * 판매or판매완료
     */
    private Boolean sale = true;

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

    private String combiId;
     */

    /**
     * 온도 아이디

    private String tempId;
     */

//    /** 상의 */
//    private String topClothesId;
//
//    /** 하의 */
//    private String bottomClothesId;
//
//    /** 상의/하의 */
//    private String pairClothesId;
//
//    /** 외투 */
//    private String outerClothesId;



//    public String getCombiId() {
//        return combiId;
//    }
//
//    public String getTempId() {
//        return tempId;
//    }

    public String getDong() {
        return dong;
    }

    public String getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getSale() {
        return sale;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategoryA() {
        return categoryA;
    }

    public String getCategoryB() {
        return categoryB;
    }

//    public String getTopClothesId() {
//        return topClothesId;
//    }
//
//    public String getBottomClothesId() {
//        return bottomClothesId;
//    }
//
//    public String getPairClothesId() {
//        return pairClothesId;
//    }
//
//    public String getOuterClothesId() {
//        return outerClothesId;
//    }
}

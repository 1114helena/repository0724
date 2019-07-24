package com.haseong.demo.entity;

import lombok.Data;

import javax.persistence.*;

public class Clothes {

  @Data
  @Entity
  @Table( name = "topclothest")
  public static class BottomEntity {

    @Id
    @Column(name = "t_clothes_id")
    private String clothesId;

    @Column(name = "t_category")
    private String category;
  }

  @Data
  @Entity
  @Table (name = "bottomclothest")
  public static class TopEntity {
    @Id
    @Column(name = "b_clothes_id")
    private String clothesId;

    @Column(name = "b_category")
    private String category;
  }

  @Data
  @Entity
  @Table( name = "pairclothest")
  public static class PairEntity {
    @Id
    @Column(name = "p_clothes_id")
    private String clothesId;

    @Column(name = "p_category")
    private String category;
  }

  @Data
  @Entity
  @Table( name = "outerclothest")
  public static class OuterEntity {
    @Id
    @Column(name = "o_clothes_id")
    private String clothesId;

    @Column(name = "o_category")
    private String category;
  }
}

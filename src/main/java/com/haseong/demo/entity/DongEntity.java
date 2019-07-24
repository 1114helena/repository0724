package com.haseong.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dong")
@Data
@EntityListeners(AuditingEntityListener.class)
public class DongEntity {
    /**
     * 동 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dong_id")
    private Integer dongId;

    /**
     * 동 이름
     */
    @Column(name = "dong")
    private Integer dong;


}

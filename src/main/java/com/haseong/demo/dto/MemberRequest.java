package com.haseong.demo.dto;

import com.haseong.demo.model.stereotype.ProviderType;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private String nickname;
    private String token;
    private String gender;
    private ProviderType providerType;
    private String providerUserId;



    public String getNickname() {
        return nickname;
    }

    public String getToken() {
        return token;
    }

    public String getGender() {
        return gender;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

}

package com.haseong.demo.service;

import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.model.stereotype.ProviderType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {

    MemberEntity createMember(String token, String nickname, String gender, ProviderType providerType, String providerUserId);

    //MemberEntity getMember(Integer memberId);
    MemberEntity getProviderUserId(String providerUserId);

    List<MemberEntity> getMembers(Pageable pageable);

    MemberEntity validateProviderUserId(String providerUserId);
}

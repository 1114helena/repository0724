package com.haseong.demo.service.impl;

import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.exception.ApiFailedException;
import com.haseong.demo.model.stereotype.ProviderType;
import com.haseong.demo.repository.MemberRepository;
import com.haseong.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberEntity createMember(String token, String nickname, String gender, ProviderType providerType, String providerUserId) {
        if (memberRepository.findByProviderTypeAndProviderUserId(providerType, providerUserId).isPresent()) {
            throw ApiFailedException.of(HttpStatus.BAD_REQUEST, "이미 가입한 회원입니다. ");
        }
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname(nickname);
        memberEntity.setGender(gender);
        memberEntity.setProviderType(providerType);
        memberEntity.setProviderUserId(providerUserId);
        return memberRepository.save(memberEntity);
    }

    @Override
    @Transactional(readOnly = true)
    //public MemberEntity getMember(Integer memberId) {
    public MemberEntity getProviderUserId(String providerUserId) {
        //return memberRepository.findById(memberId)
        //밑에 줄에 findById로 하면 안되길래, findByProviderUserId로 하니까 되던데 원래그런건지...
        //return memberRepository.findById(providerUserId)
        return memberRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "member not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberEntity> getMembers(Pageable pageable) {
        return memberRepository.findAll(pageable).getContent();
    }

    @Override
    public MemberEntity validateProviderUserId(String providerUserId) {
        return memberRepository.findByProviderUserId(providerUserId)
            .orElseThrow(() -> ApiFailedException.of(HttpStatus.NOT_FOUND, "token not found"));
    }


}

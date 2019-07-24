package com.haseong.demo.repository;

import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.model.stereotype.ProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByProviderTypeAndProviderUserId(ProviderType providerType, String providerUserId);

    //    Optional<MemberEntity> findByToken(String token);
    Optional<MemberEntity> findByProviderUserId(String providerUserId);
}

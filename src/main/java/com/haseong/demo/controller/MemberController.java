package com.haseong.demo.controller;

import com.haseong.demo.dto.MemberRequest;
import com.haseong.demo.dto.MemberResponse;
import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.service.JwtService;
import com.haseong.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;


    @Autowired
    private JwtService jwtService;


    /**
     * 로그인 처리
     * jwt 보내주기
     * @param //requestToken
     * @return
     */
    @PostMapping("/members/login")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap loginWithProviderUserId(@RequestParam("providerUserId") String providerUserId) {
        System.out.println("providerUserId : " + providerUserId);
        MemberEntity memberEntity = memberService.validateProviderUserId(providerUserId);

        String token = jwtService.create("member", memberEntity, "user");

        HashMap resultMap = new HashMap();
        resultMap.put("Authorization", token);
        return resultMap;
    }


    /**
     * 회원등록
     * @param memberRequest
     * @return
     */
    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createMember(@RequestBody MemberRequest memberRequest) {
        MemberEntity memberEntity = memberService.createMember(memberRequest.getToken(),
                memberRequest.getNickname(),
                memberRequest.getGender(),
                memberRequest.getProviderType(),
                memberRequest.getProviderUserId());
        return MemberResponse.from(memberEntity);
    }

    /**
     * 회원목록 조회
     * @param pageable
     * @return
     */
    @GetMapping("/members")
    public List<MemberResponse> getMembers(@RequestHeader(name = "Authorization") String token,
                                           Pageable pageable) {
        return memberService.getMembers(pageable).stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }


}

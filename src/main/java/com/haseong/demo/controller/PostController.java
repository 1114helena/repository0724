package com.haseong.demo.controller;

import com.haseong.demo.dto.PostRequest;
import com.haseong.demo.dto.PostResponse;
import com.haseong.demo.dto.UploadFileResponse;
import com.haseong.demo.entity.MemberEntity;
import com.haseong.demo.entity.PostEntity;
import com.haseong.demo.service.FileStorageService;
import com.haseong.demo.service.MemberService;
import com.haseong.demo.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {
    @Autowired private PostService postService;
    @Autowired private MemberService memberService;
    @Autowired private FileStorageService fileStorageService;

    /**
     * https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
     * @return
     */
    @PostMapping(value = "/uploadFile")
    public UploadFileResponse uploadFile(@RequestHeader(name = "Authorization") String token,
                                         @RequestParam("file1") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName)
            .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
            file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestHeader(name = "Authorization") String token,
                                                        @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(token, file))
            .collect(Collectors.toList());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@RequestHeader(name = "Authorization") String token,
                                                 @PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
    }



    /**
     * 글쓰기. 이미지는 일단 url 로 업로드 합니다.
     *
     * @param providerUserId    모바일이 알고 있는 회원 아이디를 x-member-id 라는 헤더에 추가해줍니다.
     * @param postRequest 게시글에 추가되어야 할 데이터
     * @return 만들어진 게시글
     */
    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse createPost(@RequestHeader(name = "Authorization") String token,
                                   //@RequestHeader(name = "x-member-id") Integer memberId,
                                   @RequestHeader(name = "x-providerUserId") String providerUserId,
                                   @RequestPart("postRequest") PostRequest postRequest,
                                   @RequestPart("file") MultipartFile file) {
        System.out.println("file : " + file);
        PostEntity postEntity =
            postService.createPost(providerUserId, postRequest);
        MemberEntity memberEntity = memberService.getProviderUserId(providerUserId);
        return PostResponse.of(postEntity, memberEntity);
    }

    /**
     * 게시글 목록을 제공합니다.
     */
    @GetMapping("/posts")
    public List<PostResponse> getPosts(@RequestHeader(name = "Authorization") String token,
                                       Pageable pageable) {
        return postService.getPosts(pageable).stream()
                .map(postEntity -> {
                    //Integer writerId = postEntity.getMemberId();
                    String writerId = postEntity.getProviderUserId();
                    MemberEntity memberEntity = memberService.getProviderUserId(writerId);
                    return PostResponse.of(postEntity, memberEntity);
                })
                .collect(Collectors.toList());
    }

    /**
     * 게시물 수정
     */
    @ApiOperation(value = "게시물 수정")
    @PostMapping("/posts/{postId}")
    public PostResponse editPost(@RequestHeader(name = "Authorization") String token,
                                 //@RequestHeader(name = "x-member-id") Integer memberId,
                                 @RequestHeader(name = "x-providerUserId") String providerUserId,
                                 @PathVariable Integer postId,
                                 @RequestBody PostRequest postRequest) {
//        PostEntity postEntity = postService.getPost(postId);
        PostEntity entity = postService.modifyPost(postId, postRequest);
        MemberEntity memberEntity = memberService.getProviderUserId(providerUserId);
        return PostResponse.of(entity, memberEntity);
    }

    /**
     * 좋아요.
     * 아직 좋아하지 않은 게시글인 경우, post의 count 가 1 증가합니다.
     * 이미 좋아했던 게시글이면, count 가 증가하지 않습니다.
     * 회원이나 게시글이 존재하지 않는 경우 404 상태 코드를 응답합니다.
     */
    @PostMapping("/posts/{postId}/like")
    public PostResponse likePost(@RequestHeader(name = "Authorization") String token,
                                 //@RequestHeader(name = "x-member-id") Integer memberId,
                                 @RequestHeader(name = "x-providerUserId") String providerUserId,
                                 @PathVariable Integer postId) {
        PostEntity postEntity = postService.likePost(providerUserId, postId);
        MemberEntity memberEntity = memberService.getProviderUserId(providerUserId);
        return PostResponse.of(postEntity, memberEntity);
    }

    /**
     * 좋아요 취소
     * 아직 좋아하지 않은 게시글인 경우, count 가 감소하지 않습니다.
     * 이미 좋아했던 게시글이면, count 가 1 감소합니다.
     * 회원이나 게시글이 존재하지 않는 경우 404 상태 코드를 응답합니다.
     */
    @PostMapping("/posts/{postId}/unlike")
    public PostResponse unlikePost(@RequestHeader(name = "Authorization") String token,
                                   //@RequestHeader(name = "x-member-id") Integer memberId,
                                   @RequestHeader(name = "x-providerUserId") String providerUserId,
                                   @PathVariable Integer postId) {
        PostEntity postEntity = postService.unlikePost(providerUserId, postId);
        MemberEntity memberEntity = memberService.getProviderUserId(providerUserId);
        return PostResponse.of(postEntity, memberEntity);
    }

    /**
     * 추천
     * 존재하는 게시글 중 랜덤으로 5개를 선택합니다.
     * 게시글의 개수가 5보다 작은 경우, 그 개수만큼 리턴합니다.
     */
    @PostMapping("/posts/recommend")
    public List<PostResponse> recommendPosts(@RequestHeader(name = "Authorization") String token,
                                             //@RequestHeader(name = "x-member-id") Integer memberId,
                                             @RequestHeader(name = "x-providerUserId") String providerUserId)
    {
        return postService.recommendPosts(providerUserId).stream()
                .map(postEntity -> {
                    String writerId = postEntity.getProviderUserId();
                    MemberEntity memberEntity = memberService.getProviderUserId(writerId);
                    return PostResponse.of(postEntity, memberEntity);
                })
                .collect(Collectors.toList());
    }


     // 내가 쓴 게시물 불러오기
     @GetMapping("/myposts")
     public List<PostResponse> myposts(Pageable pageable,
                                       @RequestHeader(name = "Authorization") String token,
                                       //@RequestHeader(name = "x-member-id") Integer memberId,
                                       @RequestHeader(name = "x-providerUserId") String providerUserId) {
         return postService.myfeeds(pageable, providerUserId).stream()
             .map(postEntity -> {
                 String writerId = postEntity.getProviderUserId();
                 MemberEntity memberEntity = memberService.getProviderUserId(writerId);
                 return PostResponse.of(postEntity, memberEntity);
             })
             .collect(Collectors.toList());
     }

}

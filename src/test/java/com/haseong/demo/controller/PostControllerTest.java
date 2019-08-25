package com.haseong.demo.controller;

import com.haseong.demo.dto.MemberRequest;
import com.haseong.demo.dto.PostRequest;
import com.haseong.demo.dto.PostResponse;
import com.haseong.demo.model.stereotype.ProviderType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.Charset;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostControllerTest {
  @Autowired private PostController postController;
  @Autowired private MemberController memberController;

  @Before
  public void initTest(){
    //    private String nickname;
    //    private String token;
    //    private String gender;
    //    private ProviderType providerType;
    //    private String providerUserId;
    memberController.createMember(new MemberRequest("nickname", "token",
        "1", ProviderType.GOOGLE, "1"));

  }

  @Test
  public void test(){
    String token = "token";
    String providerUserId = "1";
    String category = "1";

    PostResponse result = postController.getMostLikedPosts(token, providerUserId, category);
    assertNotNull(result);

  }

  @Test
  public void testDelete(){
    PostRequest request = new PostRequest("dong", "2000", "title",
        "설명", false, "url", "cateA", "cateB");
    MultipartFile f = new MockMultipartFile("test.jpg", "test.jpg", "image/jpg", "test".getBytes(Charset.forName("UTF-8")));

    PostResponse response = postController.createPost("1", "1", request, f);
    postController.deletePost("1", "1", response.getId());
  }
}

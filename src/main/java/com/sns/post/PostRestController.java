package com.sns.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sns.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	/**
	 * 게시글 업로드 API
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam(value = "content", required = false) String content,
			@RequestParam("file") MultipartFile file,
			HttpSession session) {
		// 글쓴이 번호 - session에 있는 userId를 꺼낸다.
		Integer userId = (Integer)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		Map<String, Object> result = new HashMap<>();
		if (userId == null) { // 비로그인 상태
			result.put("code", 500); 
			result.put("error_message", "로그인을 다시 해야합니다.");
			
			return result;
		}
		
		// DB insert
		postBO.addPost(userId, userLoginId, content, file);
		
		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	/**
	 * 글 삭제 API
	 * @param postId
	 * @param session
	 * @return
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("postId") int postId,
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		
		// 글 삭제를 위해 필요한 userId를 세션에서 가져온다.
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) { // 비로그인일 때
			result.put("code", 300);
			result.put("error_message", "로그인을 다시 해주세요.");
			return result;
		}
		
		// DB delete
		postBO.deletePostByPostIdUserId(postId, userId);
		
		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
} // public class PostRestController
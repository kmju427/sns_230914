package com.sns.timeline.domain;

import com.sns.post.entity.PostEntity;
import com.sns.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

// View 객체
// 글 1개와 매핑된다.
@ToString
@Data
public class CardView {
	// 게시글 1개
	private PostEntity post;
	
	// 글쓴이 정보
	private UserEntity user;
	
	// 게시글에 대한 댓글들
	
	// 좋아요 개수
	
} // public class CardView
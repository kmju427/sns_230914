package com.sns.timeline.domain;

import java.util.List;

import com.sns.comment.domain.CommentView;
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
	private List<CommentView> commentList;
	
	// 좋아요 개수
	private int likeCount;
	
	// 로그인된 사람이 좋아요를 눌렀는지의 여부
	private boolean filledLike;
	
} // public class CardView
package com.sns.comment.domain;

import com.sns.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CommentView {

	// 댓글 1개
	private Comment comment;
	
	// 댓글 쓴 사람
	private UserEntity user;
	
} // public class CommentView
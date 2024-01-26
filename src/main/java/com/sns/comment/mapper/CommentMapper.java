package com.sns.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sns.comment.domain.Comment;

@Mapper
public interface CommentMapper {

	// input : userId, postId, content / output : X
	public void insertComment(
			@Param("userId") int userId,
			@Param("postId") int postId, 
			@Param("content") String content);
	
	// input : X / output : List<Comment>
	public List<Comment> selectCommentList();
	
	// input : postId / output : List<Comment>
	public List<Comment> selectCommentListByPostId(int postId);
	
	// input : commentId / output : X
	public void deleteCommentById(int id);
	
	// input : postId / output : X
	public void deleteCommentsByPostId(int postId);
	
} // public interface CommentMapper
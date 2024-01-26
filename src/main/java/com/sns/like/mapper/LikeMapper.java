package com.sns.like.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	// 좋아요 토글
	// input : postId, userId / output : int
//	public int selectLikeCountByPostIdUserId(
//			@Param("postId") int postId, 
//			@Param("userId") int userId);
	
	// 좋아요 개수
	// public int selectLikeCountByPostId(int postId);
	
	// likeCount 쿼리 하나로 합치기
	public int selectLikeCountByPostIdOrUserId(
			@Param("postId") int postId, 
			@Param("userId") Integer userId);
	
	// 좋아요 토글
	// input : postId, userId / output : X
	public void deleteLikeByPostIdUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	// input : postId / output : X
	public void deleteLikeByPostId(int postId);
	
} // public interface LikeMapper
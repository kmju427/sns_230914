package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.mapper.LikeMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;

	// 좋아요 토글
	// input : postId, userId / output : X
	public void likeToggle(int postId, int userId) {
		// like 있으면
		if (likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) > 0) {
			// -- 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else { // like 없으면
			// -- 추가
			likeMapper.insertLike(postId, userId);
		}
	}
	
	// 좋아요 개수
	// input : postId / output : int(좋아요 개수)
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
	// 로그인된 사람이 좋아요를 눌렀는지의 여부
	// input : postId, userId(null or 있거나) / output : int
	public int getLikeCountByPostIdUserId(int postId, int userId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId);
	}
	
	// input : postId, userId(null or 있거나) / output : boolean
	public boolean getLikeCountByPostIdUserId(int postId, Integer userId) {
		// 비로그인이면 무조건 빈 하트 -> false
		if (userId == null) {
			return false;
		}
		
		// 로그인 - 0보다 크면(1) 채운다, 그렇지 않으면 false
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) > 0;
	}
	
} // public class LikeBO
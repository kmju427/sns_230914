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
		if (likeMapper.selectLikeCountByPostIdUserId(postId, userId) > 0) {
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
		return likeMapper.selectLikeCountByPostId(postId);
	}
	
	// 로그인된 사람이 좋아요를 눌렀는지의 여부
	// input : postId, userId / output : int
	public int getLikeCountByPostIdUserId(int postId, int userId) {
		return likeMapper.selectLikeCountByPostIdUserId(postId, userId);
	}
	
} // public class LikeBO
package com.sns.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;
import com.sns.timeline.domain.CardView;

@Service
public class TimelineBO {
	
	@Autowired
	private PostBO postBO;

	// input : X / output : List<CardView>
	public List<CardView> generateCardViewList() {
		List<CardView> cardViewList = new ArrayList<>();
		
		// 글 목록을 가져온다. List<PostEntity>
		List<PostEntity> postList = postBO.getPostList();
		
		// 글 목록 반복문 순회
		// post -> cardView => cardViewList에 넣기
		for (PostEntity post : postList) {
			
		}
		
		return cardViewList;
	}
	
} // public class TimelineBO
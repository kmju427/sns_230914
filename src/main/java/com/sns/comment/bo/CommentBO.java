package com.sns.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.domain.Comment;
import com.sns.comment.domain.CommentView;
import com.sns.comment.mapper.CommentMapper;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;

@Service
public class CommentBO {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private UserBO userBO;
	
	// input : userId, postId, content / output : X
	public void addComment(int userId, int postId, String content) {
		commentMapper.insertComment(userId, postId, content);
	}
	
	// input : X / output : List<Comment>
	public List<Comment> getCommentList() {
		return commentMapper.selectCommentList();
	}
	
	// input : postId / output : List<CommentView>
	public List<CommentView> generateCommentViewListByPostId(int postId) {
		// 결과 리스트 만들기
		List<CommentView> commentViewList = new ArrayList<>(); // []
		
		// 글에 해당하는 댓글 목록 가져오기 List<Comment>
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
		
		// 반복문 순회 List<Comment> -> List<CommentView> => 리스트에 넣기
		for (Comment comment : commentList) {
			CommentView commentView = new CommentView();
			
			// 댓글 1개
			commentView.setComment(comment);
			
			// 댓글 쓴 사람
			UserEntity user = userBO.getUserEntityById(comment.getUserId());
			commentView.setUser(user);
			
			// 결과 리스트에 담기
			commentViewList.add(commentView);
		}
		
		// 결과 리스트 리턴
		return commentViewList;
	}
	
} // public class CommentBO
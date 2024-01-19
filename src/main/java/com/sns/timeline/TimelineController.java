package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.Comment;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;

@RequestMapping("/timeline")
@Controller
public class TimelineController {

	// TimelineController -> TimelineBO -> PostBO, CommentBO, UserBO, LikeBO
	// TimelineController는 다른 BO를 다 부를 수 있다.
	// TimelineBO는 BO들만 부를 수 있다, 다른 BO의 mapper, repository를 부르면 안 된다.
	// 반대로는 하면 안 된다.
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	/**
	 * 타임라인 화면 - http://localhost:8080/timeline/timeline-view
	 * @param model
	 * @return
	 */
	@GetMapping("/timeline-view")
	public String timelineView(Model model) {
		// 게시글 목록 조회
		// List<PostEntity> postList = postBO.getPostList();
		// model.addAttribute("postList", postList);
		
		// 댓글 목록 조회
		// List<Comment> commentList = commentBO.getCommentList();
		// model.addAttribute("commentList", commentList);
		
		model.addAttribute("viewName", "timeline/timeline");
		
		return "template/layout";
	}
	
} // public class TimelineController
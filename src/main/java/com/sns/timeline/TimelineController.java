package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;

@RequestMapping("/timeline")
@Controller
public class TimelineController {

	@Autowired
	private PostBO postBO;
	
	/**
	 * 타임라인 화면 - http://localhost:8080/timeline/timeline-view
	 * @param model
	 * @return
	 */
	@GetMapping("/timeline-view")
	public String timelineView(Model model) {
		// 게시글 목록 조회
		List<PostEntity> postList = postBO.getPostList();
		model.addAttribute("postList", postList);
		
		model.addAttribute("viewName", "timeline/timeline");
		
		return "template/layout";
	}
	
} // public class TimelineController
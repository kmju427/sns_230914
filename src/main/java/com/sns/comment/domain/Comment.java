package com.sns.comment.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data // Getter, Setter 둘 다 가지고 있음
public class Comment {
	private int id;
	private int postId;
	private int userId;
	private String content;
	private Date createdAt;
	private Date updatedAt;
} // public class Comment
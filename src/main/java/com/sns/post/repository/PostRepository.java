package com.sns.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

	// input : X / output : List<PostEntity>
	public List<PostEntity> findAllByOrderByIdDesc();
	
	// input : postId, userId / output : PostEntity
	public PostEntity findByIdAndUserId(int postId, int userId);
	
	// input : postId / output : X
	public int deleteById(int postId);
	
} // public interface PostRepository
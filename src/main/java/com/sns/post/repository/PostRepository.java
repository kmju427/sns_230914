package com.sns.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

	// input : X / output : List<PostEntity>
	public List<PostEntity> findAllByOrderByIdDesc();
	
} // public interface PostRepository
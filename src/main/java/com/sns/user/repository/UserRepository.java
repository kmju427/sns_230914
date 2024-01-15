package com.sns.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	// 아이디 중복 조회(UserEntity or null - 단건)
	public UserEntity findByLoginId(String loginId);
	
	// 로그인(UserEntity or null - 단건)
	public UserEntity findByLoginIdAndPassword(String loginId, String password);
	
} // public interface UserRepository
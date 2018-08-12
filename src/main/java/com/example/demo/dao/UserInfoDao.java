package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.sys.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Long>{

	UserInfo findByUsername(String username);
	

}

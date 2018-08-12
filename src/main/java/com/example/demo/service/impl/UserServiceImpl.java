package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.sys.UserInfo;
import com.example.demo.service.UserInfoService;

@Service("UserInfoService")
public class UserServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfo findByUsername(String username) {
		return userInfoDao.findByUsername(username);
	}

}

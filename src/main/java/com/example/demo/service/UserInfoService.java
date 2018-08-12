package com.example.demo.service;

import com.example.demo.entity.sys.UserInfo;

public interface UserInfoService {
	
	UserInfo findByUsername(String username);

}

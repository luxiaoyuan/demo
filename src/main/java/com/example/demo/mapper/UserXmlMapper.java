package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserXmlMapper {
	
	List<UserEntity> getAll();
	UserEntity getOne(Long id);
	void insert(UserEntity user);
	void delete(UserEntity user);
	void update(UserEntity user);

}

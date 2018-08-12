package com.example.demo.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.UserSexEnum;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserXmlMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
	
	@Autowired
	//private UserMapper userMapper;
	private UserXmlMapper userMapper;
	
	@Test
	public void testInsert()throws Exception{
		userMapper.insert(new UserEntity("aa","aa123456",UserSexEnum.MAN));
		userMapper.insert(new UserEntity("bb","bb123456",UserSexEnum.WOMAN));
		userMapper.insert(new UserEntity("cc","cc123456",UserSexEnum.MAN));
		//Assert.assertEquals(3, userMapper.getAll().size());
	}
	
	
	@Test
	public void testQuery()throws Exception{
		List<UserEntity> users=userMapper.getAll();
		System.out.println("list:"+users.toString());
	}
	
	@Test
	public void testUpdate()throws Exception{
		UserEntity user=userMapper.getOne(3l);
		System.out.println("user:"+user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		System.out.println("user2:"+user.toString());
	}

}

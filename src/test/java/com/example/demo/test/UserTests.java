package com.example.demo.test;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTests {
	
	@Autowired
	private UserRepository userRepository;
	
     @Test
     public void test() throws Exception {
    	    Date date=new Date();
    	    DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
    	    String formattedDate=dateFormat.format(date);
    	    userRepository.save(new User("aa1","aa@126.com","aa","aa123456",formattedDate));
     }
     
}

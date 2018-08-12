package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@RestController 
public class HelloWorldController {
	
	@Autowired
	private UserRepository userRepository;
	
    @RequestMapping("/hello")
    public String hello(Locale locale, Model model) {
        return "Hello World";
    }
    
    @RequestMapping("/getUser")
    //@Cacheable(value="user-key")
    public User getUser() {
//        User user=new User();
//        user.setUserName("小明");
//        user.setPassWord("xxxx");
    	User user=userRepository.findByUserName("aa");
    	System.out.println("若下面没有出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    
//    public class User
//    {
//    	   private String userName;
//    	   private String passWord;
//		public String getUserName() {
//			return userName;
//		}
//		public void setUserName(String userName) {
//			this.userName = userName;
//		}
//		public String getPassWord() {
//			return passWord;
//		}
//		public void setPassWord(String passWord) {
//			this.passWord = passWord;
//		}
//    	   
//    }
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
    	    UUID uid=(UUID) session.getAttribute("uid");
    	    if(uid==null) 
    	    {
    	    	   uid=UUID.randomUUID();
    	    }
    	    session.setAttribute("uid", uid);
    	    return session.getId();
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,Map<String,Object> map) {
    	     System.out.println("HomeController.login()");
    	     //登录失败从request中获取处理的异常信息
    	     //shiroLoginFailure:就是shiro异常类的全类名
    	     String exception=(String) request.getAttribute("shiroLoginFailure");
    	     System.out.println("exception="+exception);
    	     String msg="";
    	     if(exception!=null) {
    	    	 if (UnknownAccountException.class.getName().equals(exception)) {
    	             System.out.println("UnknownAccountException -- > 账号不存在：");
    	             msg = "UnknownAccountException -- > 账号不存在：";
    	         } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
    	             System.out.println("IncorrectCredentialsException -- > 密码不正确：");
    	             msg = "IncorrectCredentialsException -- > 密码不正确：";
    	         } else if ("kaptchaValidateFailed".equals(exception)) {       
    	             System.out.println("kaptchaValidateFailed -- > 验证码错误");
    	             msg = "kaptchaValidateFailed -- > 验证码错误";
    	         } else {
    	             msg = "else >> "+exception;
    	             System.out.println("else -- >" + exception);
    	         }
    	     }
    	     
    	     //此方法不处理登录成功，由shiro进行处理
    	     return msg;
    }
    
    
    
}
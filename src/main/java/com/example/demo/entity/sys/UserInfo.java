package com.example.demo.entity.sys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * shiro -user 用户表
 * @author luxiaoyuan
 *
 */
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable{
  
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue
	 private Long id;
	 @Column(nullable=false,unique=true)
	 private String username;//账号
	 @Column(nullable=false)
	 private String name;//名称
	 @Column(nullable=false)
	 private String password;//密码
	 @Column(nullable=false)
	 private String salt;//加密密码的盐
	 private byte state;//用户状态 1  创建未认证
	 @ManyToMany(fetch=FetchType.EAGER)  //立即从数据库中进行加载数据
	 @JoinTable(name="sys_user_role",joinColumns= {@JoinColumn(name="u_id")},inverseJoinColumns= {@JoinColumn(name="role_id")})
	 private List<SysRole> roleList;//一个用户具有多个角色
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	 
	 
	 
	 
	 
	
}

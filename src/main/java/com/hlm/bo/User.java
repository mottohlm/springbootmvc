package com.hlm.bo;

import java.io.Serializable;
import java.sql.Date;


public class User implements Serializable{
	
	private static final long serialVersionUID = -1078433404507796595L;
	private Integer id ;
	private String userCode ;
	private String userName ;
	private Integer sex ;
	private String token ;
	private Date createTime ;
	private Integer tokenType ;
	private String password ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTokenType() {
		return tokenType;
	}
	public void setTokenType(Integer tokenType) {
		this.tokenType = tokenType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

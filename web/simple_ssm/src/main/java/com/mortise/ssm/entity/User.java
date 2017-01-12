package com.mortise.ssm.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {
	
	private long userId;
	
	private String userName;
	
	private long userPhone;
	
	private long createTime;
	
	private int score;

	private String pwd;


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", createTime=" + createTime + ", score=" + score
				+ "]";
	}

	

}

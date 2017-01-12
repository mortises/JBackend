package com.mortise.ssm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
	
	private long orderId;
	
	private User user;
	
	private long goodsId;
	
	private String title;
	
	private Date createTime;




	@Override
	public String toString() {
		return "Order [user=" + user + ", orderId=" + orderId + ", goodsId=" + goodsId + ", title=" + title + ", createTime=" + createTime + "]";
	}



	
	
}

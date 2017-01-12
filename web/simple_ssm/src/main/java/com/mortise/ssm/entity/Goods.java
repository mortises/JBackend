package com.mortise.ssm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mortise.ssm.util.CustomDateSerializer;
import com.mortise.ssm.validator.Not999;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class Goods {

	@Min(900)
	@Not999  //这个为自定义的验证标签
	private long goodsId;
	
	private String title;
	
	private float price;
	
	private short state;//0表示下架 1表示正常
	
	private int number;
	
	//这里展示了jackson封装好的以及自定义的对时间格式的转换方式
	//后续对于一些复杂的转换可以自定义转换方式
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private long createTime;
	
	//use timestamp
	private long updateTime;
	

	@Override
	public String toString() {
		return String.format("Goods [goodsId=%s, title=%s, price=%s, state=%s, number=%s, createTime=%s, updateTime=%s",
				goodsId, title, price, state, number, createTime, updateTime);
	}
	
	
}

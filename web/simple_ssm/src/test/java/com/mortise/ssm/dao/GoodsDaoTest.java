package com.mortise.ssm.dao;

import com.mortise.ssm.entity.Goods;
import com.mortise.ssm.util.TimeUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ut-appcontext.xml")
//@ContextConfiguration(locations = "file:webapp/WEB-INF/web.xml")
public class GoodsDaoTest {
	
	@Autowired
	private GoodsDao goodsDao;

	@Test
	public void testQueryAll() {
		List<Goods> list=goodsDao.queryAll(0, 100);
		for (Goods goods : list) {
			System.out.println(goods);
		}
		System.out.println("----------testQueryAll----------------");
	}


	@Test
	public void testSimpleQuery() {
		java.sql.Date nowDtm = TimeUtils.convertToJdbcDate(new Date());
		List<Goods> retList = goodsDao.simpleQuery(nowDtm);
		for (Goods goods : retList) {
			System.out.println(goods);
		}
		System.out.println("-------------testSimpleQuery-------------");
	}


}

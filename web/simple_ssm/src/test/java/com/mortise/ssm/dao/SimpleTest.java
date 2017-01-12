package com.mortise.ssm.dao;


import com.mortise.ssm.util.TimeUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration("classpath:spring/spring-dao.xml")
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/web.xml")
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml"/*, "classpath:spring/spring2.xml"*/ })
public class SimpleTest {

    @Autowired
    GoodsDao goodsDao;

    @Test
    public void foo() {

        Date dtmTrim = DateUtils.truncate(new Date(), Calendar.DATE);
        goodsDao.queryAll(0, 10);
        System.out.print("test");
    }
}

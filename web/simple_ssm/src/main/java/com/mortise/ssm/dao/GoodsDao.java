package com.mortise.ssm.dao;

import com.mortise.ssm.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface GoodsDao {
	 /**
     * 根据偏移量查询可用商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Goods> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    List<Goods> simpleQuery(@Param("afterDate")Date afterDate);

    
    
}

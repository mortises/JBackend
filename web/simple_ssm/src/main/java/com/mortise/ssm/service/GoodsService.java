package com.mortise.ssm.service;

import com.mortise.ssm.entity.Goods;

import java.util.Date;
import java.util.List;

public interface GoodsService {

	/**
	 * pager getter
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Goods> getGoodsList(int offset, int limit);



}

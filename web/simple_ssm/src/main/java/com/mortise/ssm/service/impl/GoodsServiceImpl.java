package com.mortise.ssm.service.impl;

import com.mortise.ssm.dao.OrderDao;
import com.mortise.ssm.cache.RedisCache;
import com.mortise.ssm.dao.GoodsDao;
import com.mortise.ssm.dao.UserDao;
import com.mortise.ssm.entity.Goods;
import com.mortise.ssm.entity.User;
import com.mortise.ssm.enums.ResultEnum;
import com.mortise.ssm.exception.BizException;
import com.mortise.ssm.service.GoodsService;
import com.mortise.ssm.util.TimeUtils;
import lombok.extern.log4j.Log4j;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;


@Log4j
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisCache cache;

	@Override
	public List<Goods> getGoodsList(int offset, int limit) {
		String cache_key = RedisCache.CAHCENAME + "|getGoodsList|" + offset + "|" + limit;
		List<Goods> result_cache = cache.getListCache(cache_key, Goods.class);
		if (result_cache != null) {
			log.info("get cache with key:" + cache_key);
		} else {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache = goodsDao.queryAll(offset, limit);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			log.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;
	}




//	@Transactional
//	@Override
//	public void buyGoods(long userPhone, long goodsId, boolean useProcedure) {
//		// 用户校验
//		User user = userDao.queryByPhone(userPhone);
//		if (user == null) {
//			throw new BizException(ResultEnum.INVALID_USER.getMsg());
//		}
//		if (useProcedure) {
//			// 通过存储方式的方法进行操作
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("userId", user.getUserId());
//			map.put("goodsId", goodsId);
//			map.put("title", "抢购");
//			map.put("result", null);
//			goodsDao.bugWithProcedure(map);
//			int result = MapUtils.getInteger(map, "result", -1);
//			if (result <= 0) {
//				// 买卖失败
//				throw new BizException(ResultEnum.INNER_ERROR.getMsg());
//			} else {
//				// 买卖成功
//				// 此时缓存中的数据不是最新的，需要对缓存进行清理（具体的缓存策略还是要根据具体需求制定）
//				cache.deleteCacheWithPattern("getGoodsList*");
//				LOG.info("delete cache with key: getGoodsList*");
//				return;
//			}
//		} else {
//
//			int inserCount = orderDao.insertOrder(user.getUserId(), goodsId, "普通买卖");
//			if (inserCount <= 0) {
//				// 买卖失败
//				throw new BizException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
//			} else {
//				// 减库存
//				int updateCount = goodsDao.reduceNumber(goodsId);
//				if (updateCount <= 0) {
//					// 减库存失败
//					throw new BizException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
//				} else {
//					// 买卖成功
//					// 此时缓存中的数据不再是最新的，需要对缓存进行清理（具体的缓存策略还是要根据具体需求制定）
//					cache.deleteCacheWithPattern("getGoodsList*");
//					LOG.info("delete cache with key: getGoodsList*");
//					return;
//				}
//			}
//		}
//	}

}

/*
* 文 件 名:  RedisService.java
* 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  huangSir
* 修改时间:  2019年9月16日
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package cn.itheima.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	JedisPool jedisPool;

	public String getOrderID(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String dayFmt = String.format("%1$03d", day);
		String hourFmt = String.format("%1$02d", hour);
		return (year - 2000) + dayFmt + hourFmt;
	}

	public Long orderId(String prefix) {
		Jedis jedis = jedisPool.getResource();
		String key = "t1_order_id" + prefix;
		String orderId = null;

		Long index = jedis.incr(key);
		orderId = prefix + String.format("%1$05d", index);
		return Long.parseLong(orderId);
	}

	public Long id() {
		return orderId(getOrderID(new Date()));
	}
}

/*
* 文 件 名:  DemoController.java
* 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  huangSir
* 修改时间:  2019年9月16日
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package cn.itheima.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.service.RedisService;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author  huangSir
* @version  [版本号, 2019年9月16日]
* @see  [相关类/方法]
* @since  [产品/模块版本]
*/
@Controller
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	RedisService redisService;

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		Long id = redisService.id();
		logger.info("id=" + id);
		return "hello world！=" + id;

	}
}

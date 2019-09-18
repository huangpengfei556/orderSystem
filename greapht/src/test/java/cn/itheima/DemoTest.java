/*
* 文 件 名:  DemoTest.java
* 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  huangSir
* 修改时间:  2019年9月17日
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package cn.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.itheima.service.RedisService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {

	@Autowired
	RedisService redisService;

	@Test
	public void Demo() {
		System.out.println(redisService.id());
	}

	public static void main(String[] args) {
		System.out.println("4b5ce2fe28308fd9".compareTo("a2f3e71d9181a67b"));
	}
}

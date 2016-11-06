package com.vips.mobile.dinner.common

import javax.annotation.Resource

import com.vips.mobile.dinner.dao.mybatis.UserDao
import com.vips.mobile.dinner.util.JsonUtils
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by cielleech on 2016/11/6.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("classpath:config/spring/dinner-servlet.xml",
  "classpath:config/spring/dinner-redis.xml", "classpath:config/spring/dinner-dao.xml"))
class MyBatisTests {
  import com.vips.mobile.dinner.common.MyBatisTests.logger

  @Resource(name = "userDao")
  var userDao: UserDao = _

  @Test
  def getUserTest(): Unit = {
    val user = userDao.getUserById(1)

    logger.info(JsonUtils.toJson(user))
  }
}

object MyBatisTests {
  val logger = LoggerFactory.getLogger(classOf[MyBatisTests])
}

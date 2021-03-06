package com.vips.mobile.dinner.common

import javax.annotation.Resource

import com.vips.mobile.dinner.dao.mybatis.UserDao
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by cielleech on 16/9/19.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("classpath:config/spring/dinner-servlet.xml",
  "classpath:config/spring/dinner-dao.xml"))
class UserDaoTests {

  import UserDaoTests.logger

  @Resource(name = "userDao")
  var dao: UserDao = _

  @Test
  def getTest(): Unit = {
    logger.info("this is a test")
  }
}

object UserDaoTests {
  val logger = LoggerFactory.getLogger(classOf[UserDaoTests])
}
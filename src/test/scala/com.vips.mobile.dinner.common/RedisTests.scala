package com.vips.mobile.dinner.common

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by cielleech on 2016/10/2.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("classpath:config/spring/dinner-servlet.xml", "classpath:config/spring/dinner-redis.xml"))
class RedisTests {
  @Autowired
  private var template: StringRedisTemplate = _

  @Test
  def setTest(): Unit = {
    template.opsForValue().set("redis", "1234")
  }

  @Test
  def getTest(): Unit = {
    println(template.opsForValue().get("redis"))
  }
}

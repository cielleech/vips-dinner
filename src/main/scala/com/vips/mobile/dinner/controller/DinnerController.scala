package com.vips.mobile.dinner.controller

import javax.servlet.http.HttpServletRequest

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by cielleech on 16/9/14.
  */
@RestController
class DinnerController {

  @RequestMapping(value = Array("/index"), method = Array(RequestMethod.GET))
  def index(request: HttpServletRequest): ModelAndView = {
    new ModelAndView("index")
  }
  
  @RequestMapping(value = Array("/vue"), method = Array(RequestMethod.GET))
  def vue(request: HttpServletRequest): ModelAndView = {
    new ModelAndView("vue")
  }
  
  @RequestMapping(value = Array("bootstrap"), method = Array(RequestMethod.GET))
  def bootstrap(request: HttpServletRequest): ModelAndView = {
    new ModelAndView("bootstrap")
  }
}

/**
 * @author cielleech
 */
object
DinnerController {
  val logger = LoggerFactory.getLogger(DinnerController.getClass)
}

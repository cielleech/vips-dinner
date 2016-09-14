package com.vips.mobile.dinner.controller

import javax.servlet.http.HttpServletRequest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}
import org.springframework.web.servlet.ModelAndView

/**
  * Created by cielleech on 16/9/14.
  */
@RestController
class DinnerController {

  @RequestMapping(value = Array("/index"), method = Array(RequestMethod.GET))
  def index(request: HttpServletRequest): String = {
    "index"
  }

  @RequestMapping(value = Array("/test"), method =  Array(RequestMethod.GET))
  def test(request: HttpServletRequest): ModelAndView = {
    new ModelAndView("index")
  }
}

object DinnerController {
  val logger = LoggerFactory.getLogger(DinnerController.getClass)
}

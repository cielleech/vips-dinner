package com.vips.mobile.dinner.util

import com.fasterxml.jackson.databind.ObjectMapper

/**
  * Created by cielleech on 16/9/10.
  */
object JsonUtils {
  private val mapper = new ObjectMapper()

  def toJson(obj: Object): String = {
    mapper.writeValueAsString(obj)
  }
}

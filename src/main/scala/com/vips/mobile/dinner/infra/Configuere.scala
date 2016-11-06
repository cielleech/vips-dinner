package com.vips.mobile.dinner

class Configurer {
  def getConfig(property: String): String = {
    "classpath:" + Option(System.getProperty("env")).getOrElse("dev") + "-env-conf.properties"
  }
}
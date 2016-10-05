package com.vips.mobile.dinner.common

import java.sql.DriverManager

import org.junit.Test

class MysqlTests {
  @Test
  def connectTest(): Unit = {
    val url = """jdbc:mysql://192.168.124.129:3306/vip_trip?user=root&password=vipshop&useUnicode=true&characterEncoding=UTF8"""

    try {
      Class.forName("com.mysql.jdbc.Driver")

      println("MySQL驱动加载成功")
      val conn = DriverManager.getConnection(url)
      val statement = conn.prepareStatement("select * from vip_region")

      val result = statement.executeQuery()

      while (result.next()) {
        println(result.getInt(1))
      }
    } catch {
      case e: Throwable => println(e.getMessage)
    }
  }
}
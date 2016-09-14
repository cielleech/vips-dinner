package com.vips.mobile.dinner.common

import java.sql.DriverManager

import com.vips.mobile.dinner.util.JsonUtils
import org.junit.Test

class MysqlTests {
  @Test
  def connectTest(): Unit = {
    val url = """jdbc:mysql://127.0.0.1:3306/vip_common?user=root&password=vipshop&useUnicode=true&characterEncoding=UTF8"""

    try {
      Class.forName("com.mysql.jdbc.Driver")

      println("MySQL驱动加载成功")
      val conn = DriverManager.getConnection(url)
      val statement = conn.prepareStatement("select * from vip_user")

      val result = statement.executeQuery()

      while (result.next()) {
        println(result.getInt(1))
      }
    }
  }
}
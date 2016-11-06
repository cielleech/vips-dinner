package com.vips.mobile.dinner.dao.mybatis

import com.vips.mobile.dinner.domain.User

trait UserDao {
  def getUserById(id: Int): User
}
package com.vips.mobile.dinner.dao.impl

import com.vips.mobile.dinner.dao.UserDao
import com.vips.mobile.dinner.domain.User
import org.springframework.stereotype.Repository

/**
  * Created by cielleech on 16/9/19.
  */
@Repository("userDao")
class UserDaoImpl extends GenericDaoImpl[User, java.lang.Long](classOf[User]) with UserDao {

}

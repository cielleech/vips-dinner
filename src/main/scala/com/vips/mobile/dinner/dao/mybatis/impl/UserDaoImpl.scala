package com.vips.mobile.dinner.dao.mybatis.impl

import com.vips.mobile.dinner.dao.mybatis.UserDao
import com.vips.mobile.dinner.domain.User
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.support.SqlSessionDaoSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("userDao")
class UserDaoImpl extends SqlSessionDaoSupport with UserDao {

  @Autowired
  override def setSqlSessionFactory(sqlSessionFactory: SqlSessionFactory): Unit = {
    super.setSqlSessionFactory(sqlSessionFactory)
  }

  override def getUserById(id: Int): User = {
    getSqlSession.selectOne("com.vips.mobile.dinner.domain.UserMapper.getUserById", 1)
  }
}
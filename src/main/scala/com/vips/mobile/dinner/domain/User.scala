package com.vips.mobile.dinner.domain

import javax.persistence._

import scala.beans.BeanProperty

/**
  * Created by cielleech on 16/9/19.
  */
@Entity
@Table(name = "vip_user")
class User {
  @BeanProperty
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Long = _
  //  @BeanProperty var name: String = _
}